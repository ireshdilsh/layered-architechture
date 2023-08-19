/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pos.layered.dao;
import java.util.ArrayList;
import jdk.swing.interop.DragSourceContextWrapper;
/**
 *
 * @author DELL
 */
public interface CrudDao<T,ID> extends SuperDao{    //T=object type(customer/item/order) // ID=type
    
     //commamn methods...
    
    boolean add(T t) throws Exception;
    boolean update(T t) throws Exception;
    boolean delete(ID id) throws Exception;
    T get(ID id) throws Exception;
    ArrayList<T>getAll() throws  Exception;
    
   
}
