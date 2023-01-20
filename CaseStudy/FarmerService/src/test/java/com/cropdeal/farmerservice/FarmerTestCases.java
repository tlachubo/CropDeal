package com.cropdeal.farmerservice;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.cropdeal.farmerservice.model.Farmer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cropdeal.farmerservice.repository.FarmerRepository;
import com.cropdeal.farmerservice.service.FarmerServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FarmerTestCases {

	@Autowired
	private FarmerServiceImpl service;

	@MockBean
	private FarmerRepository farmerrepo;
//    @Test
//    public void getFarmerTest() {
//        when(farmerrepo.findAll()).thenReturn(Stream
//                .of(new Farmer(123,"abcd","abc@123","34567889", null,null),
//                        new Farmer(321,"cba","cba@321","34567889", null,null))
//                .collect(Collectors.toList()));
//        assertEquals(2, service.getFarmersList());
//    }

	
	@Test
	public void deleteFarmerbyidTest() {
		String farmer = Farmer("999", "def", "234567", null, null);
		service.deleteById("999");
		verify(farmerrepo, times(1)).deleteById("999");
	}



	private String Farmer(String i, String string, String string2, Object object, Object object2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	void addfarmerTest() {
		Farmer farmer = new Farmer("345", "efgh", "efgh@34", "676489", null, null);
		when(farmerrepo.save(farmer)).thenReturn(farmer);
		Optional<Farmer> res = service.getFarmerById("345");
		System.out.println(res);
		equals(res.isPresent());
		
	}
	@Test
    void getFarmerByIdTest() {
		String id="2";
       service.getFarmerById("2");
       verify(farmerrepo).findById(id);
   }
	
}
