package com.sonet.core.controller;

import com.sonet.core.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Tag(name = "FriendController", description = "Контроллер для работы с друзьями")
@RestController
@RequestMapping("/friend")
@RequiredArgsConstructor
public class FriendController {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @PutMapping("/set/{user_id}")
    @PreAuthorize("hasAuthority('users:write')")
    @Operation(summary = "Добавить в друзья")
    public String create(@PathVariable("user_id") UUID friendId) {
        return "not implemented for " + friendId;
    }
}
