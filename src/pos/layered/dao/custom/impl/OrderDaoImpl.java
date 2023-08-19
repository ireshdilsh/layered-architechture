/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.dao.custom.impl;

import java.util.ArrayList;
import pos.layered.dao.CrudDao;
import pos.layered.dao.CrudUtil;
import pos.layered.dao.custom.OrderDao;
import pos.layered.entity.OrderEntity;

/**
 *
 * @author DELL
 */
public class OrderDaoImpl implements OrderDao{

    @Override
    public boolean add(OrderEntity t) throws Exception {
return CrudUtil.executeUpdate("INSERT INTO orders VALUES(?,?,?)", t.getId(),t.getDate(),t.getCustid());}

    @Override
    public boolean update(OrderEntity t) throws Exception {
return  false;}

    @Override
    public boolean delete(String id) throws Exception {
return  false;    }

    @Override
    public OrderEntity get(String id) throws Exception {
return  null;    }

    @Override
    public ArrayList<OrderEntity> getAll() throws Exception {
return  null;    }
    
}
