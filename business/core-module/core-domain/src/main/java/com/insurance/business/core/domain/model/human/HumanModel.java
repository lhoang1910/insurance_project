package com.insurance.business.core.domain.model.human;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.insurance.infrastructure.shared.base.BaseInsured;
import com.insurance.infrastructure.shared.constant.Date_TIME_FOMARTTER;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class HumanModel extends BaseInsured {

    // Thông tin người được bảo hiểm
    private String fullName;

    @JsonFormat(pattern = Date_TIME_FOMARTTER.DATE)
    private Date dateOfBirth;
    private Integer age;
    private String gender;
    private Integer identifier;
    private String indentificationCode;
    private Integer addressType;
    private String country;
    private String city;
    private String district;
    private String ward;
    private String address;
    private String occupationGroup;
    private String occupation;
    private String phoneNumber;
    private String email;
    private String contractualRelationship;

    public HumanModel(String registrationCertificateType, Date registrationStartDate, Date registrationEndDate, String insuranceCertificateNumber, Date insuranceCertificateIssueDate, String fullName, Date dateOfBirth, Integer age, String gender, Integer identifier, String indentificationCode, Integer addressType, String country, String city, String district, String ward, String address, String occupationGroup, String occupation, String phoneNumber, String email, String contractualRelationship) {
        super(registrationCertificateType, registrationStartDate, registrationEndDate, insuranceCertificateNumber, insuranceCertificateIssueDate);
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.gender = gender;
        this.identifier = identifier;
        this.indentificationCode = indentificationCode;
        this.addressType = addressType;
        this.country = country;
        this.city = city;
        this.district = district;
        this.ward = ward;
        this.address = address;
        this.occupationGroup = occupationGroup;
        this.occupation = occupation;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.contractualRelationship = contractualRelationship;
    }
}
