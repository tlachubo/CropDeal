package com.cropdeal.adminservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cropdeal.adminservice.controller.AdminController;
import com.cropdeal.adminservice.model.Admin;
import com.cropdeal.adminservice.repositpry.AdminRepository;


@SpringBootTest
class AdminServiceApplicationTests {

	@Autowired
    private AdminController admincontroller;
    

  @MockBean
    private AdminRepository adminrepo;
    
  
  
@Test
public void getadminTest() {
    when(adminrepo.findAll()).thenReturn(Stream.of(new Admin("1","abc","abc@gmail.com","12412414")).collect(Collectors.toList()));
    assertEquals(1, admincontroller.getadmin().size());
}

  

@Test
public void getadminByIdTest()  {
	String id= "1";
  admincontroller.getadminById(id);
  verify(adminrepo).findById(id);
}

  
    @Test
    public void addadminTest() {
        Admin admin = new Admin("1","abc","abc@gmail.com","12412414");
        when(adminrepo.insert(admin)).thenReturn(admin);
        Admin res=admincontroller.addadmin(admin);
        assertEquals(admin.getAdminId(),res.getAdminId());
       
    }
      
  

  @Test
    public void deleteadminbyidTest() {
        String admin = Admin("1","abc","abc@gmail.com","12412414");
        admincontroller.deleteadmin("1");
        verify(adminrepo, times(1)).deleteById("1");
    }

private String Admin(String string, String string2, String string3, String string4) {
	// TODO Auto-generated method stub
	return null;
}




  
}



