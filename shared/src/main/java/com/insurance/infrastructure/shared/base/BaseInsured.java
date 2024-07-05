package com.insurance.infrastructure.shared.base;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BaseInsured {
    private String registrationCertificateType; // Kiểu giấy chứng nhận
    private Date registrationStartDate;
    private Date registrationEndDate;
    private String insuranceCertificateNumber; // Số giấy chứng nhận bảo hiểm
    private Date insuranceCertificateIssueDate; // Ngày cấp chứng nhận bảo hiểm
}
