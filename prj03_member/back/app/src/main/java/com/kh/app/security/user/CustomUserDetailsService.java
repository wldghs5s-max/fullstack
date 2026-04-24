package com.kh.app.security.user;

import com.kh.app.member.entity.MemberEntity;
import com.kh.app.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberEntity entity = memberRepository.findByUsername(username);

        UserVo vo = new UserVo();
        vo.setUsername(entity.getUsername());
        vo.setPassword(entity.getPassword());
        vo.setRole(entity.getRole());


        return new CustomUserDetails(vo);
    }
}
