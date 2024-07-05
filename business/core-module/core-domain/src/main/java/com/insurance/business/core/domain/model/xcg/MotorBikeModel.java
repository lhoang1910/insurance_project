package com.insurance.business.core.domain.model.xcg;

import com.insurance.business.core.domain.model.premium.MotorPremium;
import com.insurance.business.core.domain.model.PaymentModel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Setter
@Getter
@NoArgsConstructor
public class MotorBikeModel extends XCGModel{

    public MotorBikeModel(String registrationCertificateType, Date registrationStartDate, Date registrationEndDate, String insuranceCertificateNumber, Date insuranceCertificateIssueDate, String brand, String version, Integer numberOfSeats, String purposeOfUse, Date mfg, String manufacturingFacility, String referenceValue, String actualValue, String model, Date firstRegistrationDate, String licensePlate, String chassisNumber, String engineNumber, List<MotorPremium> motorPremiums, Map<Integer, PaymentModel> paymentModels) {
        super(registrationCertificateType, registrationStartDate, registrationEndDate, insuranceCertificateNumber, insuranceCertificateIssueDate, brand, version, numberOfSeats, purposeOfUse, mfg, manufacturingFacility, referenceValue, actualValue, model, firstRegistrationDate, licensePlate, chassisNumber, engineNumber, motorPremiums, paymentModels);
    }

    public MotorBikeModel(String brand, String version, Integer numberOfSeats, String purposeOfUse, Date mfg, String manufacturingFacility, String referenceValue, String actualValue, String model, Date firstRegistrationDate, String licensePlate, String chassisNumber, String engineNumber, List<MotorPremium> motorPremiums, Map<Integer, PaymentModel> paymentModels) {
        super(brand, version, numberOfSeats, purposeOfUse, mfg, manufacturingFacility, referenceValue, actualValue, model, firstRegistrationDate, licensePlate, chassisNumber, engineNumber, motorPremiums, paymentModels);
    }
}
