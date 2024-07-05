package com.insurance.business.core.domain.model.human;

import java.util.Date;

public class HealthModel extends HumanModel{
    public HealthModel(String registrationCertificateType, Date registrationStartDate, Date registrationEndDate, String insuranceCertificateNumber, Date insuranceCertificateIssueDate, String fullName, Date dateOfBirth, Integer age, String gender, Integer identifier, String indentificationCode, Integer addressType, String country, String city, String district, String ward, String address, String occupationGroup, String occupation, String phoneNumber, String email, String contractualRelationship) {
        super(registrationCertificateType, registrationStartDate, registrationEndDate, insuranceCertificateNumber, insuranceCertificateIssueDate, fullName, dateOfBirth, age, gender, identifier, indentificationCode, addressType, country, city, district, ward, address, occupationGroup, occupation, phoneNumber, email, contractualRelationship);
    }
}
