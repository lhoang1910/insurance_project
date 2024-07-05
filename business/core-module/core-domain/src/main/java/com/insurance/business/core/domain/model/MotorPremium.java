package com.insurance.business.core.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MotorPremium {
    private String formInsurance;
    private Double preTaxPaymentFee;
    private Double preTaxPaymentFee;
    private Double tax;
    private Double afterTaxPaymentFee;
}
