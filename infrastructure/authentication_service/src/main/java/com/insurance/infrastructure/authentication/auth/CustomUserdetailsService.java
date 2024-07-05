package com.insurance.infrastructure.authentication.auth;

import com.insurance.infrastructure.authentication.client.UserQueryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.ws.rs.NotFoundException;

@Component
public class CustomUserdetailsService implements UserDetailsService {

    @Autowired
    private UserQueryClient userServiceClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws NotFoundException {
        var user = userServiceClient.findByUsername(username);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }

        return new UserDetail(user.get());
    }
}
