package com.cropdeal.farmerservice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
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

import com.cropdeal.farmerservice.model.Crop;
import com.cropdeal.farmerservice.model.Farmer;
import com.cropdeal.farmerservice.service.FarmerService;

@RestController
@RequestMapping("/farmer")
public class FarmerController {
	Logger log = LoggerFactory.getLogger(FarmerController.class);

	@Autowired
	private RestTemplate restTemp;

	@Autowired
	FarmerService farmerservice;

	@GetMapping("/findfarmers")
	public List<Farmer> getfarmer() {
		log.info("the available farmers are viewed");
		log.info("farmers: ",farmerservice.findAll());
		return farmerservice.findAll();
	}

	@GetMapping("/getFarmerById/{id}")
	public Optional<Farmer> getfarmerById(@PathVariable String id) {
		log.info("the available farmers by ID's are viewed");
		return farmerservice.getFarmerById(id);
	}

	@PostMapping("/addfarmer")
	public Farmer addfarmer(@RequestBody Farmer farmer) {
		log.info("the farmers are added");
		return farmerservice.addFarmer(farmer);
	}

	@PutMapping("/updatefarmer")
	public Farmer updateFarmer(@RequestBody Farmer farmer) {
		log.info("the farmers are updated");
		return farmerservice.updateFarmer(farmer);
	}

	@DeleteMapping("/deletefarmer/{id}")
	public String deletefarmer(@PathVariable String id) {
		farmerservice.deleteById(id);
		log.info("the farmers are deleted by ID");
		return "farmer deleted having id " + id;
	}

	@GetMapping("/farmer/get/crop")
	public List<Object> getCropatFarmer() {
		log.info("farmer can have a look of the available crops");
		Object[] crop = restTemp.getForObject("http://CropService/crop/findcrops", Object[].class);
		return Arrays.asList(crop);
	}

	@GetMapping("/farmer/get/crop/{id}")
	public Crop getCropatFarmerbyID(@PathVariable("id") String id) {
		log.info("farmer can get a particular crop");
		Crop crop = restTemp.getForObject("http://CropService/crop/getCropById/" + id, Crop.class);
		return crop;
	}

	@RequestMapping(value = "/farmer/delete/crop/{id}", method = RequestMethod.DELETE)
	public String deleteCropById(@PathVariable("id") String id) {
		log.info("farmer deleted the crop he wanrt to remove ");
		return restTemp.exchange("http://CropService/crop/deletecrop/" + id, HttpMethod.DELETE, null, String.class)
				.getBody();
	}

	@RequestMapping(value = "/farmer/add/crop", method = RequestMethod.POST)
	public String addCropatFarmer(@RequestBody Crop crop) {
		log.info("farmer can add crops");
		HttpEntity<Crop> entity = new HttpEntity<Crop>(crop);
		return restTemp.exchange("http://CropService/crop/addcrop", HttpMethod.POST, entity, String.class).getBody();

	}

	@RequestMapping(value = "/farmer/update/crop/{id}", method = RequestMethod.PUT)
	public String updateCropatFarmer(@RequestBody Crop crop) {
		log.info("farmer can update the crop");
		HttpEntity<Crop> entity = new HttpEntity<Crop>(crop);
		return restTemp.exchange("http://CropService/crop/updatecrop/", HttpMethod.PUT, entity, String.class).getBody();

	}

}
