package com.insurance.business.core.domain.repository;

import com.insurance.business.core.domain.entity.EventStoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventStoreRepository extends JpaRepository<EventStoreEntity, String> {

    @Query("select count (*) from EventStoreEntity where aggregateId = :id")
    long numberOfEvent(String id);

    @Query(value = "SELECT * FROM event_store_entity WHERE aggregate_id = ?1 ORDER BY updated_at DESC LIMIT 1", nativeQuery = true)
    Optional<EventStoreEntity> findFirstByVersion(@Param("id") String id);
}
