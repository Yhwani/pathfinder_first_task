package first_task.first_task.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import first_task.first_task.filter.JsonLoginAuthenticationFilter;
import first_task.first_task.handler.LoginHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    private final ObjectMapper objectMapper;
    private final UserDetailsService userDetailsService;
    private final LoginHandler loginHandler;
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeRequests().requestMatchers(
                        new AntPathRequestMatcher("/**")).permitAll();

        http.csrf(AbstractHttpConfigurer::disable)
                .headers((headers) -> headers.disable());

        http.formLogin(httpSecurityFormLoginConfigurer
                -> httpSecurityFormLoginConfigurer
                .usernameParameter("userId")
                .passwordParameter("password")
                .loginPage("/member/login")
                .defaultSuccessUrl("/")
                .failureUrl("/member/login"));

        http.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry
                        .requestMatchers("/member/login").permitAll()
                        .anyRequest().authenticated());
        return http.build();
    }
    @Bean
    public JsonLoginAuthenticationFilter jsonUsernamePasswordAuthenticationFilter() {
        JsonLoginAuthenticationFilter jsonLoginAuthenticationFilter =
                new JsonLoginAuthenticationFilter(objectMapper, loginHandler, loginHandler);
        jsonLoginAuthenticationFilter.setAuthenticationManager(authenticationManager());
        return jsonLoginAuthenticationFilter;
    }
    @Bean
    AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService);

        return new ProviderManager(provider);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
