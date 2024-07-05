package com.insurance.business.core.command.utils;

import com.insurance.infrastructure.shared.base.BasePremium;

import java.util.HashMap;
import java.util.Map;

public class PaymentFeeTransfer {

    public static Map<String, Object> paymentFee(BasePremium premium, Map<String, Object> premiumInfo) {

        Map<String, Object> paymentFee = new HashMap<>();
        paymentFee.put("type", premium.getType());
        paymentFee.put("sumInsured", premium.getSumInsured());
        paymentFee.put("premiumRate", premium.getPremiumRate());
        paymentFee.put("standardPremium", premium.getStandardPremium());
        paymentFee.put("discountRate", premium.getDiscountRate());
        paymentFee.put("premiumRateRatio", premium.getPremiumRateRatio());
        paymentFee.put("paymentPremium", premium.getPaymentPremium());
        paymentFee.put("sumPremium", premium.getSumPremium());
        return paymentFee;
    }

}
