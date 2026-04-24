package com.kh.app.security.user;

import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails {

    private final UserVo vo;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (vo.getRole() == null || vo.getRole().isBlank()) {
            throw new RuntimeException("권한(role) 없음");
        }
        return List.of(
                new SimpleGrantedAuthority(vo.getRole())
        );
    }

    @Override
    public @Nullable String getPassword() {
        return vo.getPassword();
    }

    @Override
    public String getUsername() {
        return vo.getUsername();
    }
}
