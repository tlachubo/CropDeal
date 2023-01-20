package com.cropdeal.dealerservice;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import com.cropdeal.dealerservice.models.Dealer;
import com.cropdeal.dealerservice.repository.DealerRepository;
import com.cropdeal.dealerservice.service.DealerServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DealerTestCaases {
	
	@Test
	public void applicationTest() {
		DealerServiceApplication.main(new String [] {});
	}
	
	@Autowired
    private DealerServiceImpl service;



   @MockBean
    private DealerRepository dealerrepo;

   @Test
   public void deletedealerTest() {
	   
       when(dealerrepo.findAll()).thenReturn(Stream
               .of(new Dealer("1", "abc", "abc@gmail.com", "12412414", "12244", null)).collect(Collectors.toList()));
       service.deleteById("1");
       verify(dealerrepo, times(1)).deleteById("1");
  }

   @Test
    public void adddealerTest() {
        Dealer dealer = new Dealer("1", "abc", "abc@gmail.com", "12412414", "12244", null);
        when(dealerrepo.save(dealer)).thenReturn(dealer);
        Optional<Dealer> res = service.getDealerById("1");
        equals(res.isPresent());
    }



   @Test
    public void getdealerTest() {
	   
        when(dealerrepo.findAll()).thenReturn(Stream
                .of(new Dealer("1", "abc", "abc@gmail.com", "12412414", "12244", null)).collect(Collectors.toList()));
        Optional<Dealer> dealer=service.getDealerById("1");
        equals(dealer.isPresent());
   }

  

   @Test
    public void deletedealerbyidTest() {
        String dealer = Dealer("1", "abc", "abc@gmail.com", "12412414", "12244", null);
        service.deleteById("1");
        verify(dealerrepo, times(1)).deleteById("1");
    }


@Test
   private String Dealer(String string, String string2, String string3, String string4, String string5,
            Object object) {
        // TODO Auto-generated method stub
        return null;
    }



   @Test
    public void getdealerByIdTest() {
        String id = "1";
        service.getDealerById(id);
        verify(dealerrepo).findById(id);
    }



}


