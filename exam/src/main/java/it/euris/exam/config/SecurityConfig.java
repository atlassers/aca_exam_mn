package it.euris.exam.config;


import com.google.common.collect.ImmutableList;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
    public class SecurityConfig  extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.cors().and().csrf().disable().authorizeRequests()
                    .antMatchers("/actuator/*", "/swagger-ui.html**", "/webjars/**", "/v3/**").authenticated()
                    .antMatchers("/halls/**").hasRole("manager")
                    .antMatchers("/shows/**").hasRole("manager")
                    .antMatchers("/theatres/**").hasRole("manager")
                    .antMatchers("/users/**").hasRole("manager")
                    .antMatchers("/tickets/**").hasRole("manager")
                    .and().httpBasic();
            ;
        }

        @Bean
        public CorsConfigurationSource corsConfigurationSource() {
            final CorsConfiguration configuration = new CorsConfiguration();
            configuration.setAllowedOrigins(ImmutableList.of("*"));
            configuration.setAllowedMethods(ImmutableList.of("GET", "POST", "PUT", "DELETE", "PATCH"));
            configuration.setAllowCredentials(false);
            configuration.setAllowedHeaders(ImmutableList.of("Authorization", "Cache-Control", "Content-Type"));
            final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", configuration);
            return source;

        }
}
