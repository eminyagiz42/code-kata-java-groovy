package curiousity.fundamental.inheritence.superconstructor;

import java.math.BigDecimal;

public class CartV2 extends Cart {

    int extendedCartId;

    /**
     *  This method below is completely the same as the right one.
     *  The super constructor calls constructor from parent.
     *  and it reduces code duplication
     *  and it's useful when we want to use parent constructor and modify it easily
     */
    public CartV2(String customerId, BigDecimal grandTotal, CartTypeEnum type, CartStatusEnum status, int extendedCartId) {

        super(customerId, grandTotal, type, status); /** is completely the same ->**/ // this.customerId = customerId;
                                                                                      // this.grandTotal = grandTotal;
                                                                                      // this.type = type;
                                                                                      // this.status = status;
        this.extendedCartId = extendedCartId;
    }

    @Override
    public String toString() {
        return "CartV2{" + super.toString() +
                ", extendedCartId=" + extendedCartId +
                '}';
    }
}
