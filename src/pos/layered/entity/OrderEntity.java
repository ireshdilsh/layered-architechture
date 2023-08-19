/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.entity;

/**
 *
 * @author DELL
 */
public class OrderEntity {
    private String id;
    private String date;
    private String custid;

    public OrderEntity() {
    }

    public OrderEntity(String id, String date, String custid) {
        this.id = id;
        this.date = date;
        this.custid = custid;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the custid
     */
    public String getCustid() {
        return custid;
    }

    /**
     * @param custid the custid to set
     */
    public void setCustid(String custid) {
        this.custid = custid;
    }

    @Override
    public String toString() {
        return "OrderEntity{" + "id=" + id + ", date=" + date + ", custid=" + custid + '}';
    }
    
    
}
