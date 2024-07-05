package com.insurance.business.core.domain.repository;

import com.insurance.business.core.domain.entity.QuotationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuotationRepository extends JpaRepository<QuotationEntity, String> {
}
