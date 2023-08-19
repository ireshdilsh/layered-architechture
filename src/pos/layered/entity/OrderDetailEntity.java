/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.entity;

/**
 *
 * @author DELL
 */
public class OrderDetailEntity {
    private String orderid;
    private String itmid;  
    private Integer qty;
 private double dicount;
    public OrderDetailEntity() {
    }

    public OrderDetailEntity(String orderid, String itmid,  Integer qty,double dicount) {
        this.orderid = orderid;
        this.itmid = itmid;
                this.qty = qty;

        this.dicount = dicount;
      
    }

    /**
     * @return the orderid
     */
    public String getOrderid() {
        return orderid;
    }

    /**
     * @param orderid the orderid to set
     */
    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    /**
     * @return the itmid
     */
    public String getItmid() {
        return itmid;
    }

    /**
     * @param itmid the itmid to set
     */
    public void setItmid(String itmid) {
        this.itmid = itmid;
    }

    /**
     * @return the dicount
     */
    public double getDicount() {
        return dicount;
    }

    /**
     * @param dicount the dicount to set
     */
    public void setDicount(double dicount) {
        this.dicount = dicount;
    }

    /**
     * @return the qty
     */
    public Integer getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "OrderDetailEntity{" + "orderid=" + orderid + ", itmid=" + itmid + ", dicount=" + dicount + ", qty=" + qty + '}';
    }
    
    
}
