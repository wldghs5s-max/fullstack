package com.kh.app.security.config;

import com.kh.app.security.filter.CustomLoginFilter;
import com.kh.app.security.filter.JwtFilter;
import com.kh.app.security.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import tools.jackson.databind.ObjectMapper;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityFilterChainConfig {

    private final ObjectMapper objectMapper;
    private final JwtUtil jwtUtil;
    private final AuthenticationConfiguration configuration;

    @Bean
    public AuthenticationManager authenticationManager(){
        return configuration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity hs){

        //불필요한 설정 끄기
        hs.csrf(AbstractHttpConfigurer::disable);
        hs.formLogin(AbstractHttpConfigurer::disable);
        hs.httpBasic(AbstractHttpConfigurer::disable);
        hs.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        //URL 매핑
        hs.authorizeHttpRequests(
                auth ->
                        auth
                                .requestMatchers("/api/home").permitAll()
                                .requestMatchers("/api/login").permitAll()
                                .requestMatchers("/api/member/join").permitAll()
                                .requestMatchers("/api/board/**").permitAll()
                                .requestMatchers("/api/notice/insert").hasAuthority("ADMIN")
                                .requestMatchers("/api/user").authenticated()
                                .requestMatchers("/api/admin").hasAuthority("ADMIN")
                                .anyRequest().authenticated()
        );

        //JWT 필터 설정
        JwtFilter jwtFilter = new JwtFilter(jwtUtil);
        hs.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        //로그인 필터 설정
        CustomLoginFilter customLoginFilter = new CustomLoginFilter(authenticationManager(), jwtUtil, objectMapper);
        customLoginFilter.setFilterProcessesUrl("/api/login");
        hs.addFilterAt(customLoginFilter, UsernamePasswordAuthenticationFilter.class);


        //CORS
        hs.cors(
                corsCustomizer -> corsCustomizer.configurationSource(new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {

                        CorsConfiguration conf = new CorsConfiguration();

                        conf.addAllowedOrigin("http://127.0.0.1:5173");
                        conf.addAllowedHeader("*");
                        conf.addAllowedMethod("*");
                        conf.setAllowCredentials(true);
                        conf.addExposedHeader("*");

                        return conf;
                    }
                })
        );
        return hs.build();
    }

}
