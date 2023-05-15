//package br.com.loja.fcs.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration {
//
//    public static final String[] ENDPOINTS_WHITELIST = {
//            "/css/**",
//            "/",
//            "/login",
//            "/home"
//    };
//    public static final String LOGIN_URL = "/login";
//    public static final String LOGOUT_URL = "/logout";
//    public static final String LOGIN_FAIL_URL = LOGIN_URL + "?error";
//    public static final String DEFAULT_SUCCESS_URL = "/alguma-coisa";
//    public static final String USERNAME = "username";
//    public static final String PASSWORD = "password";
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeRequests(request ->
//                        request.antMatchers(ENDPOINTS_WHITELIST).permitAll()
//                                .anyRequest().authenticated())
//                .csrf().disable()
//                .formLogin(form -> form
//                        .loginPage(LOGIN_URL).permitAll()
//                        .loginProcessingUrl(LOGIN_URL).permitAll()
//                        .failureUrl(LOGIN_FAIL_URL).permitAll()
//                        .usernameParameter(USERNAME).permitAll()
//                        .passwordParameter(PASSWORD)
//                        .permitAll()
//                        .defaultSuccessUrl(DEFAULT_SUCCESS_URL));
//        return http.build();
//    }
//
//}
//
//
//
//
//
//
//
//
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        http
////                .authorizeRequests()
////                .antMatchers("/swagger-ui.html", "/swagger-resources/**", "/v2/api-docs", "/webjars/**")
////                .permitAll()
////                .antMatchers("/produtos").hasAnyRole("USER", "ADMIN")
////                .antMatchers("/produtos/{id}").hasAnyRole("USER", "ADMIN")
////                .antMatchers(HttpMethod.POST, "/produtos").hasRole("ADMIN")
////                .antMatchers(HttpMethod.PUT, "/produtos/{id}").hasRole("ADMIN")
////                .anyRequest().authenticated()
////                .and()
////                .formLogin()
////                .loginPage("/login")
////                .permitAll()
////                .and()
////                .logout()
////                .logoutUrl("/logout")
////                .logoutSuccessUrl("/login")
////                .permitAll();
////
////        http.headers().frameOptions().sameOrigin();
////        http.userDetailsService(userDetailsService);
////
////        return http.build();
////    }
////
////    @Bean
////    public WebSecurityCustomizer webSecurityCustomizer() throws Exception {
////        return (web) -> web.ignoring().antMatchers("/produtos");
////    }
////
////    @Autowired
////    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////        auth
////                .inMemoryAuthentication()
////                .withUser("admin").password("{noop}admin").roles("ADMIN")
////                .and().withUser("user").password("{noop}user").roles("USER");
////    }