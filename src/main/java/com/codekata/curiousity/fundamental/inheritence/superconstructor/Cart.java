package com.codekata.curiousity.fundamental.inheritence.superconstructor;


import java.math.BigDecimal;


public class Cart {

    private String customerId;
    private BigDecimal grandTotal;
    private CartTypeEnum type;
    private CartStatusEnum status;

    public Cart(String customerId, BigDecimal grandTotal, CartTypeEnum type, CartStatusEnum status) {
        this.customerId = customerId;
        this.grandTotal = grandTotal;
        this.type = type;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "customerId='" + customerId + '\'' +
                ", grandTotal=" + grandTotal +
                ", type=" + type +
                ", status=" + status +
                '}';
    }
}
