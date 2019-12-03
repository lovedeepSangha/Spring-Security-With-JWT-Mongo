package com.example.springsecuritywithmongo.config;

import com.example.springsecuritywithmongo.filters.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * created by lovedeep in com.example.springsecuritywithmongo.config
 */
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Qualifier("MongoUserDetail")
    @Autowired
    UserDetailsService userDetailsService;



    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests().antMatchers("/authenticate").permitAll().
                anyRequest().authenticated().and().
                exceptionHandling().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

    }








































//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//       auth.userDetailsService(userDetailsService);
//    }
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        http.
////                csrf().disable().
////                sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
////                and().
////                authorizeRequests().
////                anyRequest().authenticated().
////                and().
////                anonymous().disable()
////                .mvcMatchers("/admin").hasAuthority("ADMIN")
////                .antMatchers("/admin").hasRole("ADMIN")
////                .antMatchers("/user").hasAnyRole("ADMIN", "USER")
////                .antMatchers("/").permitAll().and()
////                .exceptionHandling().accessDeniedPage("/access");
//////                .antMatchers("/switchuserto").hasRole("SUPER_ADMIN");
////    }
//
//        http.authorizeRequests()
//                .mvcMatchers("/admin").hasAuthority("ADMIN")
//                .antMatchers("/admin").hasRole("ADMIN")
//                .antMatchers("/user").hasAnyRole("ADMIN", "USER")
//                .antMatchers("/").permitAll().and()
//                .exceptionHandling().accessDeniedPage("/access")
//                .and().formLogin();
////                .and().formLogin().disable();
//
//    }
//    @Bean
//    public PasswordEncoder getPasswordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//










}
