package com.cropdeal.adminservice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cropdeal.adminservice.filters.JwtUtil;
import com.cropdeal.adminservice.model.Admin;
import com.cropdeal.adminservice.model.AuthenticationRequest;
import com.cropdeal.adminservice.model.AuthenticationResponse;
import com.cropdeal.adminservice.model.Crop;
import com.cropdeal.adminservice.model.Dealer;
import com.cropdeal.adminservice.model.Farmer;
import com.cropdeal.adminservice.model.UserModel;
import com.cropdeal.adminservice.repositpry.UserRepository;
import com.cropdeal.adminservice.service.AdminService;
import com.cropdeal.adminservice.service.MyUserDetailsService;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private RestTemplate restTemp;

	@Autowired
	AdminService adminservice;
	
         @Autowired
        private AuthenticationManager authenticationManager;
        @Autowired
        private MyUserDetailsService userDetailsService;
        @Autowired
        private JwtUtil jwtTokenUtil;
        @Autowired
        private UserRepository repo;
        
        Logger log=(Logger) LoggerFactory.getLogger(AdminController.class);

	@GetMapping("/findadmins")
	public List<Admin> getadmin() {
		log.info("All admins are viewed");
		return adminservice.findAll();
	}

	@GetMapping("/getAdminById/{id}")
	public Optional<Admin> getadminById(@PathVariable String id) {
		log.info(" admin based on id is viewed");
		return adminservice.getAdminById(id);
	}

	@PostMapping("/addadmin")
	public Admin addadmin(@RequestBody Admin admin) {
		log.info(" New admin details are added");
		return adminservice.addAdmin(admin);
	}

	@PutMapping("/updateadmin")
	public Admin updateadmin(@RequestBody Admin admin) {
		log.info("admin details are updated");
		return adminservice.updateAdmin(admin);
	}

	@DeleteMapping("/deleteadmin/{id}")
	public String deleteadmin(@PathVariable String id) {
		log.info("Deleted admin based on id");
		adminservice.deleteById(id);
		return "admin deleted having id " + id;
	}


	//---------------get crops-----------

	@GetMapping("/admin/get/crop")
	public List<Object> getCropatAdmin() {
		log.info("admin can have a look of the available crops");
		Object[] crop = restTemp.getForObject("http://CropService/crop/findcrops", Object[].class);
		return Arrays.asList(crop);
	}
	// -------------get crops by id----------------

	@GetMapping("/admin/get/crop/{id}")
	public Crop getCropatAdminbyID(@PathVariable("id") String id) {
		log.info("admin can get a particular crop");
		Crop crop = restTemp.getForObject("http://CropService/crop/getCropById/" + id, Crop.class);
		return crop;

	}

	
//-------------delete the crop by admin---------------------

@RequestMapping(value = "/admin/delete/crop/{id}", method = RequestMethod.DELETE)
public String deleteCropById(@PathVariable("id") String id) {
	log.info("admin can delete the crops ");
return restTemp.exchange("http://CropService/crop/deletecrop/" + id, HttpMethod.DELETE, null, String.class).getBody();
}
	
	// ---------------get farmers-----------

	@GetMapping("/admin/get/farmer")
	public List<Object> getFarmeratAdmin() {
		log.info("admin can have a look of all farmers");
		Object[] farmer = restTemp.getForObject("http://FarmerService/farmer/findfarmers", Object[].class);
		return Arrays.asList(farmer);
	}
	
	// -------------get farmer by id----------------

	@GetMapping("/admin/get/farmer/{id}")
	public Farmer getFarmeratAdminbyID(@PathVariable("id") String id) {
		log.info("admin can get a particular farmer");
		Farmer farmer = restTemp.getForObject("http://FarmerService/farmer/getFarmerById/" + id, Farmer.class);
		return farmer;
	}


	
	
	// -------------delete the farmer by admin---------------------

	@RequestMapping(value = "/admin/delete/farmer/{id}", method = RequestMethod.DELETE)
	public String deleteFarmerById(@PathVariable("id") String id) {
		log.info("admin deleted the farmer he want to remove ");
		return restTemp
				.exchange("http://FarmerService/farmer/deletefarmer/" + id, HttpMethod.DELETE, null, String.class)
				.getBody();
	}

	// ---------------get dealers---------

	@GetMapping("/admin/get/dealer")
	public List<Object> getDealeratAdmin() {
		log.info("admin can have a look of all dealers");
		Object[] dealer = restTemp.getForObject("http://DealerService/dealer/finddealers", Object[].class);
		return Arrays.asList(dealer);
	}
	// -------------get dealer by id----------------
	
	@GetMapping("/admin/get/dealer/{id}")
	public Dealer getDealeratAdminbyID(@PathVariable("id") String id) {
		log.info("admin can get a particular dealer");
		Dealer dealer = restTemp.getForObject("http://DealerService/dealer/getDealerById/" + id, Dealer.class);
		return dealer;
	}

	// -------------delete the dealer by admin---------------------

	@RequestMapping(value = "/admin/delete/dealer/{id}", method = RequestMethod.DELETE)
	public String deleteDealerById(@PathVariable("id") String id) {
		log.info("admin deleted the dealer he want to remove ");
		return restTemp
				.exchange("http://DealerService/dealer/deletedealer/" + id, HttpMethod.DELETE, null, String.class)
				.getBody();
	}

	
	 /*-----------------------------------security----------------------------------*/
		
		@PostMapping("/reg")
		private ResponseEntity<?> subscribe(@RequestBody AuthenticationRequest request) {

        String username =request.getUsername();
        String password =request.getPassword();
 
        UserModel model = new UserModel();
        model.setUsername(username);
        model.setPassword(password);

        try { 
            repo.save(model);
        } catch (Exception e) {
            return ResponseEntity.ok(new AuthenticationResponse("Error while subsribing the user with username " + username));
        }
            return ResponseEntity.ok(new AuthenticationResponse("client subscribed with username " + username));
    }

		@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
		public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
				throws Exception {
			try {
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
						authenticationRequest.getUsername(), authenticationRequest.getPassword()));
			} catch (BadCredentialsException e) {
				throw new Exception("Incorrect username or password", e);
			}

			final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

			final String jwt = jwtTokenUtil.generateToken(userDetails);

			return ResponseEntity.ok(new AuthenticationResponse(jwt));
		}

}


