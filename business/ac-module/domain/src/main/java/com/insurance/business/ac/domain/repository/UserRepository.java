package com.insurance.business.ac.domain.repository;

import com.insurance.business.ac.domain.entity.UserEntity;
import com.insurance.infrastructure.shared.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    Optional<UserModel> findByUsername(String username);

    @Query(value = "SELECT user_code FROM users ORDER BY user_code DESC LIMIT 1", nativeQuery = true)
    String getLatestUserCode();

    boolean existsByUsername(String username);

    Optional<UserEntity> findUserByUsername(String username);
}
