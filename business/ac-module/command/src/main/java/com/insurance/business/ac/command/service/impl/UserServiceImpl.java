package com.insurance.business.ac.command.service.impl;

import com.insurance.business.ac.command.handler.UserCommandHandler;
import com.insurance.business.ac.command.service.UserService;
import com.insurance.business.ac.domain.repository.UserRepository;
import com.insurance.infrastructure.shared.command.user.CreateUserCommand;
import com.insurance.infrastructure.shared.command.user.DeleteUserCommand;
import com.insurance.infrastructure.shared.command.user.UpdateUserCommand;
import com.insurance.infrastructure.shared.request.user.CreateUserRequest;
import com.insurance.infrastructure.shared.request.user.UpdateUserRequest;
import com.insurance.infrastructure.shared.response.WrapResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserCommandHandler cmdHandler;
    private final UserRepository repository;

    public static String generateNewUserCode(String latestUserCode) {
        if (latestUserCode == null){
            return "U001";
        }
        int numOfUser = Integer.parseInt(latestUserCode.substring(1));
        return String.format("U%03d", numOfUser + 1);
    }


    @Override
    public WrapResponse<?> createUser(CreateUserRequest request, String username) {
        cmdHandler.handle(CreateUserCommand.builder()
                        .userCode(generateNewUserCode(repository.getLatestUserCode()))
                        .department(request.getDepartment())
                        .username(request.getUsername())
                        .password(request.getPassword())
                        .workSite(request.getWorkSite())
                        .department(request.getDepartment())
                        .username(username)
                .build());
        return new WrapResponse<>(true, HttpStatus.OK.value(), "Create User Successfully", null);
    }

    @Override
    public WrapResponse<?> updateUser(String id, UpdateUserRequest request, String username) {
        cmdHandler.handle(
                UpdateUserCommand.builder()
                        .id(id)
                        .department(request.getDepartment())
                        .workSite(request.getWorkSite())
                        .updatedBy(username)
                        .password(request.getPassword())
                        .build());
        return new WrapResponse<>(true, HttpStatus.OK.value(), "Update User Successfully", null);
    }

    @Override
    public WrapResponse<?> deleteUser(String id, String username) {
        cmdHandler.handle(
                DeleteUserCommand.builder()
                        .id(id)
                        .updatedBy(username)
                        .build()
        );
        return new WrapResponse<>(true, HttpStatus.OK.value(), "Delete User Successfully", null);
    }
}
