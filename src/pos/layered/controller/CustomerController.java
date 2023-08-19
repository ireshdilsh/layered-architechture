/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.controller;

import java.util.ArrayList;
import pos.layered.dto.CustomerDto;
import pos.layered.service.ServiceFactory;
import pos.layered.service.custom.CustomerService;
import pos.layered.service.custom.impl.CustomerServiceImpl;

/**
 *
 * @author DELL
 */
public class CustomerController {
         CustomerService customerService=(CustomerService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CUSTOMER);
   
         public String addCustomer(CustomerDto customerDto) throws Exception {
           return customerService.addCustomer(customerDto);
    }

    
    public String updateCustomer(CustomerDto customerDto) throws Exception {
         return customerService.updateCustomer(customerDto);
    }

    public String deleteCustomer(String custID) throws Exception {
         return customerService.deleteCustomer(custID);
    }

    public CustomerDto getCustomer(String custID) throws Exception {
       return customerService.getCustomer(custID);
    }

    public ArrayList<CustomerDto> getAllCustomers() throws Exception {
return customerService.getAllCustomer();
    
    }

    

    
}
