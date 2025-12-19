package mk.finki.ukim.wp.lab.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

    public final PasswordEncoder passwordEncoder;
    private final AuthProvider authProvider;

    public WebSecurityConfig(PasswordEncoder passwordEncoder, AuthProvider authProvider){
        this.passwordEncoder = passwordEncoder;
        this.authProvider = authProvider;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
            http
                    .csrf(AbstractHttpConfigurer::disable)
                    .authenticationProvider(authProvider)
                    .headers(headers -> headers
                            .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin)
                    )
                    .authorizeHttpRequests(req -> req

                            .requestMatchers("/register","/login","/" , "/h2-con/**", "/error").permitAll()
                            .requestMatchers(HttpMethod.GET, "/books").permitAll()
                            .requestMatchers("/css/**", "/js/**").permitAll()

                            .requestMatchers("/books/new", "/books/edit/**", "/books/delete/**").hasRole("ADMIN")
                            .requestMatchers(HttpMethod.POST, "/books/**").hasRole("ADMIN")
                            .requestMatchers(HttpMethod.PUT, "/books/**").hasRole("ADMIN")
                            .requestMatchers(HttpMethod.DELETE, "/books/**").hasRole("ADMIN")

                            .anyRequest().authenticated()
                    )
                    .formLogin(form -> form
                            .loginPage("/login")
                            .permitAll()
                            .failureUrl("/login?error=BadCredentials")
                            .defaultSuccessUrl("/books", true)
                    )
                    .logout(logout -> logout
                            .logoutSuccessUrl("/")
                            .clearAuthentication(true)
                            .invalidateHttpSession(true)
                            .deleteCookies("JSESSIONID")
                            .permitAll()

                    );
            return http.build();


    }



    @Bean
    public UserDetailsService userDetailsService (){
        UserDetails user1 = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("marko123"))
                .roles("ADMIN")
                .build();

        UserDetails user2 = User.builder()
                .username("marko")
                .password(passwordEncoder.encode("marko123"))
                .roles("USER")
                .build();


        return new InMemoryUserDetailsManager(user1, user2);
    }
    @Bean
    public  AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(authProvider);
        return authenticationManagerBuilder.build();
    }



}
