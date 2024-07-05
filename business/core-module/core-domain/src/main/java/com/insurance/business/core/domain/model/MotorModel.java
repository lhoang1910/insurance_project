package com.insurance.business.core.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MotorModel {

    // Thông tin chính
    private String brand;
    private String version;
    private String vehicleType; // Dòng xe
    private String purposeOfUse;
    private Date mfg;
    private String manufacturingFacility;
    private String referenceValue;
    private String actualValue;
    private Boolean iSUselectric;
    private Boolean isIncludesBatteryValue;
    private String carModel;    // Loại xe
    private Integer numberOfSeats;
    private Double payload;
    private Date firstRegistrationDate;
    private String licensePlate;
    private String chassisNumber; // Số khung
    private String engineNumber; // Số máy
    private String registrationCertificateType; // Kiểu giấy chứng nhận
    private Date registrationStartDate;
    private Date registrationEndDate;
    private String insuranceCertificateNumber; // Số giấy chứng nhận bảo hiểm
    private Date insuranceCertificateIssueDate; // Ngày cấp chứng nhận bảo hiểm

    // Thông tin bổ sung
    private String fuelType;
    private Integer odometerReading; // Số công tơ mét
    private String color;
    private String transmissionType; // Kiểu hộp số
    private Double engineDisplacement; // Dung tích



}
