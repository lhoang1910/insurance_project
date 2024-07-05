package com.insurance.business.core.domain.model.human;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class TripModel extends HumanModel{
    private Integer travelType;
    private String purposeOfTrip;
    private String departureCountry;
    private String destinationCountry;
    private String dateAmount;

    public TripModel(String registrationCertificateType, Date registrationStartDate, Date registrationEndDate, String insuranceCertificateNumber, Date insuranceCertificateIssueDate, String fullName, Date dateOfBirth, Integer age, String gender, Integer identifier, String indentificationCode, Integer addressType, String country, String city, String district, String ward, String address, String occupationGroup, String occupation, String phoneNumber, String email, String contractualRelationship, Integer travelType, String purposeOfTrip, String departureCountry, String destinationCountry, String dateAmount) {
        super(registrationCertificateType, registrationStartDate, registrationEndDate, insuranceCertificateNumber, insuranceCertificateIssueDate, fullName, dateOfBirth, age, gender, identifier, indentificationCode, addressType, country, city, district, ward, address, occupationGroup, occupation, phoneNumber, email, contractualRelationship);
        this.travelType = travelType;
        this.purposeOfTrip = purposeOfTrip;
        this.departureCountry = departureCountry;
        this.destinationCountry = destinationCountry;
        this.dateAmount = dateAmount;
    }
}
