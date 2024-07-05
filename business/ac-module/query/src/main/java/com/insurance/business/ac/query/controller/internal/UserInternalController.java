package com.insurance.business.ac.query.controller.internal;

import com.insurance.business.ac.domain.entity.UserEntity;
import com.insurance.business.ac.query.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/internal/api/user")
@RequiredArgsConstructor
public class UserInternalController {

    private final UserService userService;

    @GetMapping("/exitsByUsername/{username}")
    boolean existsByUsername(@PathVariable String username) {
        return userService.exitByUsername(username);
    }

    @GetMapping("/findUserByUsername/{username}")
    Optional<UserEntity> findUserByUsername(@PathVariable String username) {
        return userService.findUserByUsername(username);
    }
}
