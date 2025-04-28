package uz.pdp.exam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(registry -> {
            registry
                    .requestMatchers("login").permitAll()
                    .anyRequest().authenticated();
        });

        http.formLogin(formLogin -> {
            formLogin.defaultSuccessUrl("#", true).permitAll();

        });

        http.logout(logout ->
                logout.logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
        );


        return http.build();
    }
}
