/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.dao;

import pos.layered.dao.custom.impl.CustomerDaoImpl;
import pos.layered.dao.custom.impl.ItemDaoImpl;
import pos.layered.dao.custom.impl.OrderDaoImpl;
import pos.layered.dao.custom.impl.OrderDetailImpl;

/**
 *
 * @author DELL
 */
public class DaoFactory {
     private DaoFactory(){}
     private static DaoFactory daoFactory;
     
     public static DaoFactory getInstance(){
     
        if(daoFactory==null){
           daoFactory=new DaoFactory();
        }else{
        
        }
        return daoFactory;
     }
     
     public SuperDao getDao(DaoTypes type){
         switch (type) {
             case CUSTOMER:
             return new CustomerDaoImpl();
             case ITEM:
                 return new ItemDaoImpl();
                 case ORDER:
                 return new OrderDaoImpl();
                 case ORDER_DETAIL:
                 return new OrderDetailImpl();
             default:
            return null;
        }
     }
     public  enum DaoTypes{
        CUSTOMER ,ITEM, ORDER,ORDER_DETAIL
     }
}
