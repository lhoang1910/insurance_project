package com.insurance.business.ac.command.controller.internal;

import com.insurance.business.ac.command.service.UserService;
import com.insurance.infrastructure.shared.request.user.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/internal/api/users")
public class UserInternalController {

    private final UserService userService;

    @PostMapping("/create")
    public boolean create(@RequestBody CreateUserRequest request, @RequestHeader("loggedInUser") String username) {
        return userService.createUser(request, username).getIsSuccess();
    }

}
