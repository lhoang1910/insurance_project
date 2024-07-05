package com.insurance.business.ac.command.service;

import com.insurance.infrastructure.shared.request.user.CreateUserRequest;
import com.insurance.infrastructure.shared.request.user.UpdateUserRequest;
import com.insurance.infrastructure.shared.response.WrapResponse;

public interface UserService {

    WrapResponse<?> createUser(CreateUserRequest request, String username);

    WrapResponse<?> updateUser(String id, UpdateUserRequest request, String username);

    WrapResponse<?> deleteUser(String id, String username);
}
