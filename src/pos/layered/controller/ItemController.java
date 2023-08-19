/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.controller;

import java.util.ArrayList;
import pos.layered.dto.CustomerDto;
import pos.layered.dto.ItemDto;
import pos.layered.service.ServiceFactory;
import pos.layered.service.custom.CustomerService;
import pos.layered.service.custom.ItemService;

/**
 *
 * @author DELL
 */
public class ItemController {
     ItemService itemService=(ItemService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ITEM);
   
    public String addItem(ItemDto itemDto) throws Exception {
       return itemService.addItem(itemDto);
    }

    public String updateItem(ItemDto itemDto) throws Exception {
        return itemService.updateItem(itemDto);
    }

    public String deleteCustomer(String text) throws Exception {
        return itemService.deleteItem(text);
    }

    public ArrayList<ItemDto> getAllItem() throws Exception {
        return itemService.getAllItem();
    }

    public ItemDto getItem(String orderid) throws Exception {
         return itemService.getItem(orderid);
    }
    
}
