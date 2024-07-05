package com.insurance.infrastructure.authentication.client;

import com.insurance.infrastructure.shared.model.UserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "user-query", path = "/internal/api/user")
public interface UserQueryClient {

    @GetMapping("/exitsByUsername/{username}")
    boolean existsByUsername(@PathVariable String username);

    @GetMapping("/find/{username}")
    Optional<UserModel> findByUsername(@PathVariable String username);

}