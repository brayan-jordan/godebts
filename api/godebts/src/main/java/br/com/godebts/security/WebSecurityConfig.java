package br.com.godebts.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private ImplementsUserDetailsService implementsUserDetailsService;
    private JWTRequestFilter jwtRequestFilter;

    private static final String[] USUARIO_LIST = {
            "",
    };

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, USUARIO_LIST).hasRole("usuario")
                .antMatchers(HttpMethod.PUT, USUARIO_LIST).hasRole("usuario")
                .antMatchers(HttpMethod.PATCH, USUARIO_LIST).hasRole("usuario")
                .antMatchers(HttpMethod.POST, USUARIO_LIST).hasRole("usuario")
                .antMatchers(HttpMethod.DELETE, USUARIO_LIST).hasRole("usuario")
                .antMatchers(HttpMethod.PATCH, USUARIO_LIST).permitAll()
                .antMatchers(HttpMethod.GET, USUARIO_LIST).permitAll()
                .antMatchers(HttpMethod.PUT, USUARIO_LIST).permitAll()
                .antMatchers(HttpMethod.POST,USUARIO_LIST).permitAll()
                .antMatchers(HttpMethod.DELETE,USUARIO_LIST).permitAll()
                .antMatchers(HttpMethod.POST,"/login").permitAll()
                .anyRequest().authenticated()
                .and().cors()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .deleteCookies("token").invalidateHttpSession(true);
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder.userDetailsService(implementsUserDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    public void configure(WebSecurity webSecurity) throws Exception{
        webSecurity.ignoring().antMatchers("/bootstrap/**", "/style/**");
    }

}
