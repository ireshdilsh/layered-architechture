/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.dto;

import java.util.List;

/**
 *
 * @author DELL
 */
public class OrderDto {
    private String orderid;
    private String customerid;
    
    private List<OrderDetailDto>orderDetailDtos;

    public OrderDto() {
    }

    public OrderDto(String orderid, String customerid, List<OrderDetailDto> orderDetailDtos) {
        this.orderid = orderid;
        this.customerid = customerid;
        this.orderDetailDtos = orderDetailDtos;
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
     * @return the customerid
     */
    public String getCustomerid() {
        return customerid;
    }

    /**
     * @param customerid the customerid to set
     */
    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    /**
     * @return the orderDetailDtos
     */
    public List<OrderDetailDto> getOrderDetailDtos() {
        return orderDetailDtos;
    }

    /**
     * @param orderDetailDtos the orderDetailDtos to set
     */
    public void setOrderDetailDtos(List<OrderDetailDto> orderDetailDtos) {
        this.orderDetailDtos = orderDetailDtos;
    }

    @Override
    public String toString() {
        return "OrderDto{" + "orderid=" + orderid + ", customerid=" + customerid + ", orderDetailDtos=" + orderDetailDtos + '}';
    }

   
    
}
