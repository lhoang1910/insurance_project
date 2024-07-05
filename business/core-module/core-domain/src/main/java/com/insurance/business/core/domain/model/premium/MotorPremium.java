package com.insurance.business.core.domain.model.premium;

import com.insurance.infrastructure.shared.base.BasePremium;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MotorPremium extends BasePremium {

    private Double preTaxPaymentFee;
    private Double tax;
    private String additionalInformation;
    private Double deductible;  // Mức khấu trừ

    @Builder
    public MotorPremium(String type, Double sumInsured, Double premiumRate, Double standardPremium, Double discountRate, Double claimsRatio, Double paymentPremium, Long sumPremium, Double preTaxPaymentFee, Double tax, String additionalInformation, Double deductible) {
        super(type, sumInsured, premiumRate, standardPremium, discountRate, claimsRatio, paymentPremium, sumPremium);
        this.preTaxPaymentFee = preTaxPaymentFee;
        this.tax = tax;
        this.additionalInformation = additionalInformation;
        this.deductible = deductible;
    }
}
