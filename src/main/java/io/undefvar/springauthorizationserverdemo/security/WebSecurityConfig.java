package io.undefvar.springauthorizationserverdemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig {
//    @Bean
//    SecurityFilterChain configureSecurityFilterChain(HttpSecurity http) throws Exception {
//
//        http
//                .authorizeHttpRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated())
//                .formLogin(Customizer.withDefaults());
//
//        return http.build();

//    }

    @Bean
    public UserDetailsService users() {

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        UserDetails user = User.withUsername("undefvar")
                .password(encoder.encode("password"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);

    }
}
