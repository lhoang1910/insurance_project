package com.insurance.infrastructure.authentication.service;

import com.insurance.infrastructure.shared.model.UserModel;
import com.insurance.infrastructure.shared.request.user.CreateUserRequest;
import com.insurance.infrastructure.shared.request.user.LoginRequest;
import com.insurance.infrastructure.shared.response.WrapResponse;
import org.springframework.web.bind.annotation.RequestHeader;

public interface AuthService {

    WrapResponse<?> createUser(CreateUserRequest request, String loggedInUser);

    WrapResponse<?> login(LoginRequest request);

    UserModel getCurrentUser(@RequestHeader("loggedInUser") String username);

}
