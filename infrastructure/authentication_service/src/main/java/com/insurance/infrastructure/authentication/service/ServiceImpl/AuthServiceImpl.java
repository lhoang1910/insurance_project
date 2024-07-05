package com.insurance.infrastructure.authentication.service.ServiceImpl;

import com.insurance.infrastructure.authentication.client.UserCommandClient;
import com.insurance.infrastructure.authentication.client.UserQueryClient;
import com.insurance.infrastructure.authentication.service.AuthService;
import com.insurance.infrastructure.authentication.utils.GenerateJwt;
import com.insurance.infrastructure.shared.model.UserModel;
import com.insurance.infrastructure.shared.request.user.CreateUserRequest;
import com.insurance.infrastructure.shared.request.user.LoginRequest;
import com.insurance.infrastructure.shared.response.WrapResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final GenerateJwt generateJwt;
    private final UserCommandClient userCommandClient;
    private final UserQueryClient userQueryClient;

    @Override
    public WrapResponse<?> createUser(CreateUserRequest request, String loggedInUser) {

        var existingUser = userQueryClient.existsByUsername(loggedInUser);

        if (existingUser){
            return new WrapResponse<>(false, HttpStatus.BAD_REQUEST.value(), "Username already exists", null);
        }

        if (loggedInUser == null || loggedInUser.isEmpty()) {
            request.setUpdatedBy("Register");
        }
        request.setUpdatedBy(loggedInUser);
        request.setPassword(passwordEncoder.encode(request.getPassword()));

        Boolean isCreateSucess = userCommandClient.createUser(request);
        if (!isCreateSucess) {
            return new WrapResponse<>(false, HttpStatus.BAD_REQUEST.value(), "Failed to create user", null);
        }
        return new WrapResponse<>(true, HttpStatus.OK.value(), "Succes to create user", null);
    }

    @Override
    public WrapResponse<?> login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        if (authentication.isAuthenticated()) {
            String jwtToken = generateJwt.generateToken(request.getUsername());
            return new WrapResponse<>(true, HttpStatus.OK.value(), "Login is success", jwtToken);
        }
        return new WrapResponse<>(true, HttpStatus.UNAUTHORIZED.value(), "Username or password is incorrect", null);
    }

    @Override
    public UserModel getCurrentUser(@RequestHeader("loggedInUser") String username) {
        var currentUser = userQueryClient.findByUsername(username);

        if (currentUser.isEmpty()) {
            return UserModel.builder()
                    .username("Annoymous user")
                    .build();
        }

        return UserModel.builder()
                .id(currentUser.get().getId())
                .userCode(currentUser.get().getUserCode())
                .username(currentUser.get().getUsername())
                .password(currentUser.get().getPassword())
                .department(currentUser.get().getDepartment())
                .isDeleted(currentUser.get().getIsDeleted())
                .workSite(currentUser.get().getWorkSite())
                .build();
    }
}
