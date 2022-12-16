package taller.BD.Server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
      
    @Autowired
    private UserServ userdetail;
    
    @Bean
    public BCryptPasswordEncoder Codif() {
        return new BCryptPasswordEncoder();
    }

    // Se define la clase que recupera los usuarios y el algoritmo para procesar las passwords
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userdetail).passwordEncoder(Codif());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    
	http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    .and().cors().and().csrf().disable()
	.authorizeRequests().
    antMatchers("/pers").hasRole("AUTORIZADO")
    .antMatchers(HttpMethod.GET,"/movimientoses").hasRole("AUTORIZADO")
    .antMatchers(HttpMethod.POST,"/movimientoses").hasRole("ADMIN")
    .antMatchers("/cuentases").hasRole("ADMIN")
    .anyRequest().authenticated().and().httpBasic();
	
    }
}