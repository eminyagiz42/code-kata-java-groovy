package com.codekata.curiousity.fundamental.inheritence.superconstructor;


import java.math.BigDecimal;


/**
 * The type Cart.
 */
public class Cart {

    private String customerId;
    private BigDecimal grandTotal;
    private CartTypeEnum type;
    private CartStatusEnum status;

    /**
     * Instantiates a new Cart.
     *
     * @param customerId the customer id
     * @param grandTotal the grand total
     * @param type       the type
     * @param status     the status
     */
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
