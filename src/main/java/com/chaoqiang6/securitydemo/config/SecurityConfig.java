package com.chaoqiang6.securitydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                //需要与login.html中的action一致
                .loginProcessingUrl("/login")
                .loginPage("/login.html")
                //注意，此处的forwordurl必须是post请求
                .successForwardUrl("/login")
                .failureForwardUrl("/toError");


        http.authorizeRequests()
                .antMatchers("/login.html").permitAll()
                .antMatchers("/error.html").permitAll()
                .anyRequest().authenticated();
        //关闭csrf防护
        http.csrf().disable();
//        super.configure(http);
    }
}
