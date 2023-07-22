//package first_task.first_task.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//@RequiredArgsConstructor
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests().requestMatchers(
//                        new AntPathRequestMatcher("/**")).permitAll();
//
//        http.csrf(AbstractHttpConfigurer::disable)
//                .headers((headers) -> headers.disable());
//
//        http.formLogin(httpSecurityFormLoginConfigurer
//                -> httpSecurityFormLoginConfigurer
//                .usernameParameter("userId")
//                .passwordParameter("password")
//                .loginPage("/member/login")
//                .defaultSuccessUrl("/")
//                .failureUrl("/member/login"));
//
//        http.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry
//                        .requestMatchers("/member/login").permitAll()
//                        .anyRequest().authenticated());
//
//        http.sessionManagement(httpSecuritySessionManagementConfigurer ->
//                httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//
//        return http.build();
//    }
//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//}
