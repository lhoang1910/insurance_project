package com.insurance.business.core.command.utils;

import com.insurance.infrastructure.shared.base.BaseInsured;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InsuranceObjectTransfer {

    public static List<Map<String, Object>> insuranceObjects(BaseInsured insured, List<Map<String, Object>> insuranceObjectInfos) {
        List<Map<String, Object>> insuranceObjects = new ArrayList<>();

        for (Map<String, Object> i : insuranceObjectInfos) {
            Map<String, Object> updatedObject = new HashMap<>(i);
            updatedObject.put("registrationCertificateType", insured.getRegistrationCertificateType());
            updatedObject.put("registrationStartDate", insured.getRegistrationStartDate());
            updatedObject.put("registrationEndDate", insured.getRegistrationEndDate());
            updatedObject.put("insuranceCertificateNumber", insured.getInsuranceCertificateNumber());
            updatedObject.put("insuranceCertificateIssueDate", insured.getInsuranceCertificateIssueDate());

            insuranceObjects.add(updatedObject);
        }

        return insuranceObjects;
    }

}
