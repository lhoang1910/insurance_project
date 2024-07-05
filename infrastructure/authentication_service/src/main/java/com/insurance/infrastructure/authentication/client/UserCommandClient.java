package com.insurance.infrastructure.authentication.client;

import com.insurance.infrastructure.shared.request.user.CreateUserRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "user-command", path = "/internal/api/users")
public interface UserCommandClient {

    @PostMapping("/create")
    boolean createUser(@RequestBody CreateUserRequest request);

}
