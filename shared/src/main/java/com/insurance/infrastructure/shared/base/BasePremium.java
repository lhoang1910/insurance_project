package com.insurance.infrastructure.shared.base;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BasePremium {

    private String type;    // Quyền lợi/loại hình
    private Double sumInsured;  //STBH
    private Double premiumRate;     //Tỉ lệ phí
    private Double standardPremium; // Phí chuẩn
    private Double discountRate;    // Tỉ lệ giảm phí
    private Double premiumRateRatio;     // Tỉ lệ phí thanh toán
    private Double paymentPremium;     // Phí thanh toán
    private Long sumPremium;

}
