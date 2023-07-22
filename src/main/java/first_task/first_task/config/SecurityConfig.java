package first_task.first_task.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutFilter;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsService userDetailsService;
    private final JsonLoginProcessFilter jsonLoginProcessFilter;
    private final ObjectMapper objectMapper;
    private final AuthenticationManager authenticationManager;
    @Bean
    public WebSecurityCustomizer configure() {
        return (web -> web.ignoring()
                .requestMatchers("/static/**"));
    }
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeRequests().requestMatchers("/member/login","/signup","/member").permitAll()
                .anyRequest().authenticated();

        http.csrf(AbstractHttpConfigurer::disable)
                .headers((headers) -> headers.disable());

//        http.formLogin(httpSecurityFormLoginConfigurer
//                        -> httpSecurityFormLoginConfigurer
//                        .usernameParameter("userId")
//                        .passwordParameter("password")
//                        .loginPage("/member/login")
//                        .loginProcessingUrl("/member/login")
//                        .defaultSuccessUrl("/")
//                        .failureUrl("/member/login"))
//                .logout(httpSecurityLogoutConfigurer
//                        -> httpSecurityLogoutConfigurer
//                        .logoutSuccessUrl("/")
//                        .invalidateHttpSession(true)); // form 형태 로그인일 때
        http.addFilterAfter(jsonLoginProcessFilter, LogoutFilter.class);    //json 로그인

//        http.sessionManagement(httpSecuritySessionManagementConfigurer ->
//                httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() throws Exception{
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }
    @Bean
    public JsonLoginProcessFilter jsonLoginProcessFilter() {
        JsonLoginProcessFilter jsonLoginProcessFilter = new JsonLoginProcessFilter(objectMapper, authenticationManager);
        jsonLoginProcessFilter.setAuthenticationSuccessHandler((request, response, authentication) -> {
            response.getWriter().println("Success Login");
        });
        return jsonLoginProcessFilter;
    }
}