package com.insurance.infrastructure.shared.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BaseInsured {
    private String registrationCertificateType; // Kiểu giấy chứng nhận
    private Date registrationStartDate;
    private Date registrationEndDate;
    private String insuranceCertificateNumber; // Số giấy chứng nhận bảo hiểm
    private Date insuranceCertificateIssueDate; // Ngày cấp chứng nhận bảo hiểm
}
