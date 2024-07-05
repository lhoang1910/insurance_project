package com.insurance.business.ac.command.controller;

import com.insurance.business.ac.command.service.UserService;
import com.insurance.infrastructure.shared.request.user.CreateUserRequest;
import com.insurance.infrastructure.shared.request.user.UpdateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CreateUserRequest request, @RequestHeader(value = "loggedInUser", defaultValue = "Anonymous") String username) {
        return ResponseEntity.ok(userService.createUser(request, username));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody UpdateUserRequest request
            , @PathVariable String id, @RequestHeader(value = "loggedInUser", defaultValue = "Anonymous") String username) {
        return ResponseEntity.ok(userService.updateUser(id, request, username));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id, @RequestHeader(value = "loggedInUser", defaultValue = "Anonymous") String username) {
        return ResponseEntity.ok(userService.deleteUser(id, username));
    }
}
