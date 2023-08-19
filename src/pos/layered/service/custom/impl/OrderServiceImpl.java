/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.service.custom.impl;

import pos.layered.dao.DaoFactory;
import pos.layered.dao.custom.ItemDao;
import pos.layered.dao.custom.OrderDao;
import pos.layered.dao.custom.OrderDetailDao;
import pos.layered.dto.OrderDto;
import pos.layered.service.custom.OrderService;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import pos.layered.db.DBConnection;
import pos.layered.dto.OrderDetailDto;
import pos.layered.entity.ItemEntity;
import pos.layered.entity.OrderDetailEntity;
import pos.layered.entity.OrderEntity;

/**
 *
 * @author DELL
 */
public class OrderServiceImpl implements OrderService {

    OrderDetailDao orderDetailDao = (OrderDetailDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ORDER_DETAIL);
    ItemDao itemDao = (ItemDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ITEM);
    OrderDao orderDao = (OrderDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ORDER);

    @Override
    public String plcaeOrder(OrderDto dto) throws Exception {
                   Connection connection = DBConnection.getInstance().getConnection();
        
        try {
            connection.setAutoCommit(false);
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            
            if(orderDao.add(new OrderEntity(dto.getOrderid(), sdf.format(new Date()), dto.getCustomerid()))){
                boolean isOrderDetailAdded = true;
                
                for (OrderDetailDto detailDto : dto.getOrderDetailDtos()) {
                    if(!orderDetailDao.add(new OrderDetailEntity(dto.getOrderid(), detailDto.getItemid(), detailDto.getQty(), detailDto.getDiscount()))){
                        isOrderDetailAdded = false;
                    }
                }
                
                if(isOrderDetailAdded){
                    boolean isItemUpdated = true;
                    
                    for (OrderDetailDto detailDto : dto.getOrderDetailDtos()) {
                        ItemEntity entity = itemDao.get(detailDto.getItemid());
                        entity.setQoh(entity.getQoh()- detailDto.getQty());
                        if(!itemDao.update(entity)){
                            isItemUpdated = false;
                        }
                    }
                    
                    if(isItemUpdated){
                        connection.commit();
                        return "Success";
                    } else{
                        connection.rollback();
                        return "Item Update Error";
                    }
                    
                } else{
                    connection.rollback();
                    return "Order Detail Save Error";
                }
            } else{
                connection.rollback();
                return "Order Save Error";
            }
            
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }    
    }

    

 /*   private OrderDao orderDao = (OrderDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ORDER);
    private OrderDetailDao OrderDetailDao = (OrderDetailDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ORDER_DETAIL);
    private ItemDao itemDao = (ItemDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ITEM);

    @Override
    public String plcaeOrder(OrderDto dto) throws Exception {
        
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        
        try {
            SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd");
            if (orderDao.add(new OrderEntity(dto.getOrderid(), adf.format(new Date()), dto.getCustomerid()))) {
                boolean isOrderSaved = true;
                for (OrderDetailDto orderDetailDto : dto.getOrderDetailDtos()) {
                    if (OrderDetailDao.add(new OrderDetailEntity(dto.getOrderid(),
                            orderDetailDto.getItemid(),
                            orderDetailDto.getQty(),
                            orderDetailDto.getDiscount()))) {
                        isOrderSaved = false;
                    }

                }
                if (isOrderSaved) {
                    boolean isItemUpdate = true;
                    for (OrderDetailDto orderDetailDto : dto.getOrderDetailDtos()) {
                        ItemEntity entity = itemDao.get(orderDetailDto.getItemid());
                        entity.setQoh(entity.getQoh() - orderDetailDto.getQty());

                        if (!itemDao.update(entity)) {
                            isItemUpdate = false;
                        }
                    }
                    if (isItemUpdate) {
                        connection.commit();
                        return "Success";
                    } else {
                        connection.rollback();
                        return "Item Update Error";
                    }
                } else {
                    connection.rollback();
                    return "Order Detail Save Error";
                }
            } else {
                connection.rollback();
                return "Order Save Error";
            }
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
            return e.getMessage();
        } finally {
            connection.setAutoCommit(true);
        }*/
    
    }


