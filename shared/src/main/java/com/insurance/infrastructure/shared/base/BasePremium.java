package com.insurance.infrastructure.shared.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasePremium {

    private String type;    // Quyền lợi/loại hình
    private Double sumInsured;  //STBH
    private Double premiumRate;     //Tỉ lệ phí
    private Double standardPremium; // Phí chuẩn
    private Double discountRate;    // Tỉ lệ giảm phí
    private Double claimsRatio;     // Tỉ lệ phí thanh toán
    private Double paymentPremium;     // Phí thanh toán
    private Long sumPremium;

}
