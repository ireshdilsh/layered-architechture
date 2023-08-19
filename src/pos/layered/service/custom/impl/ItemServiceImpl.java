/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.service.custom.impl;

import java.util.ArrayList;
import pos.layered.dao.DaoFactory;
import pos.layered.dao.custom.CustomerDao;
import pos.layered.dao.custom.ItemDao;
import pos.layered.dto.CustomerDto;
import pos.layered.dto.ItemDto;
import pos.layered.entity.CustomerEntity;
import pos.layered.entity.ItemEntity;
import pos.layered.service.custom.ItemService;

/**
 *
 * @author DELL
 */
public class ItemServiceImpl implements ItemService {

    ItemDao itemDao = (ItemDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ITEM);

    @Override
    public String addItem(ItemDto itemDto) throws Exception {

        ItemEntity itemEntity = new ItemEntity(itemDto.getItemcode(),
                itemDto.getDiscription(),
                itemDto.getPacksize(),
                itemDto.getUnitprice(),
                itemDto.getQoh());

        if (itemDao.add(itemEntity)) {
            return "Success added Item";
        } else {
            return "Fail";
        }
    }

    @Override
    public String updateItem(ItemDto itemDto) throws Exception {
        ItemEntity itemEntity = new ItemEntity(itemDto.getItemcode(),
                itemDto.getDiscription(),
                itemDto.getPacksize(),
                itemDto.getUnitprice(),
                itemDto.getQoh());

        if (itemDao.update(itemEntity)) {
            return "Success Updated";
        } else {
            return "Fail";
        }

    }

    @Override
    public String deleteItem(String id) throws Exception {
        if (itemDao.delete(id)) {
            return "Deleted Successfull";
        } else {
            return "Fail";
        }

    }

    @Override
    public ItemDto getItem(String id) throws Exception {
        ItemEntity entity = itemDao.get(id);
        return new ItemDto(entity.getItemcode(),
                entity.getDiscription(),
                entity.getPacksize(),
                entity.getUnitprice(),
                entity.getQoh());
    }

    @Override
    public ArrayList<ItemDto> getAllItem() throws Exception {
        
        ArrayList<ItemDto> itemDtos = new ArrayList<>();
        ArrayList<ItemEntity> itemEntitys = itemDao.getAll();

        for (ItemEntity itemEntity : itemEntitys) {
            ItemDto dto = new ItemDto(itemEntity.getItemcode(),
                    itemEntity.getDiscription(),
                    itemEntity.getPacksize(),
                    itemEntity.getUnitprice(),
                    itemEntity.getQoh());
            itemDtos.add(dto);
        }
        return itemDtos;
    }

}
