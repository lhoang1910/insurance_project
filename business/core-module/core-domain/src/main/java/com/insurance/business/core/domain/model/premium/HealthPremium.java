package com.insurance.business.core.domain.model.premium;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.insurance.infrastructure.shared.base.BasePremium;
import com.insurance.infrastructure.shared.constant.Date_TIME_FOMARTTER;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class HealthPremium extends BasePremium {

    private Boolean waitingPreiod;  // Thời gian chờ

    @JsonFormat(pattern = Date_TIME_FOMARTTER.DATE)
    private Date effectiveDate;

    @Builder
    public HealthPremium(String type, Double sumInsured, Double premiumRate, Double standardPremium, Double discountRate, Double claimsRatio, Double paymentPremium, Long sumPremium, Boolean waitingPreiod, Date effectiveDate) {
        super(type, sumInsured, premiumRate, standardPremium, discountRate, claimsRatio, paymentPremium, sumPremium);
        this.waitingPreiod = waitingPreiod;
        this.effectiveDate = effectiveDate;
    }
}
