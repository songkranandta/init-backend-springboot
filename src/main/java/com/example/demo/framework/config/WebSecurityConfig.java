package com.example.demo.framework.config;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Log4j2
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final ApplicationConfig applicationConfig;


    public static CorsConfigurationSource corsConfigurationSource(ApplicationConfig applicationConfig) {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(applicationConfig.getCors().getAllowedOrigins());
        configuration.setAllowedMethods(applicationConfig.getCors().getAllowedMethods());
        configuration.setAllowedHeaders(applicationConfig.getCors().getAllowedHeaders());
        configuration.setAllowCredentials(applicationConfig.getCors().getAllowCredentials());
        configuration.setMaxAge(applicationConfig.getCors().getMaxAge());
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/authenticate/**")
                .antMatchers("/signon/**")
                .antMatchers("/v2/api-docs")
                .antMatchers("/swagger-resources/**")
                .antMatchers("/swagger-ui.html")
                .antMatchers("/configuration/**")
                .antMatchers("/faq/**")
                .antMatchers("/webjars/**");

    }
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        log.debug("HttpSecurity JwtConfig Setup");

            httpSecurity.csrf().disable()
                    .cors().configurationSource(corsConfigurationSource(applicationConfig)).and()
                    .authorizeRequests().antMatchers("/**").permitAll()
                    .and()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        httpSecurity.headers().frameOptions().disable();
    }


}
