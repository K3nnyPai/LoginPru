package com.siifo.siifo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.siifo.siifo.service.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    String[] resources = new String[]{
        "/static/**", "/include/**", "/css/**","/icons/**","/img/**","/js/**","/layer/**"
};
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(requests -> requests
                        .antMatchers(resources).permitAll()
                        .antMatchers("/", "/index", "/contacto", "/sonido", "/banquetes", "/recreacion", "/colegios", "/recreacion/ferias", "/recreacion/decoraciones", "/recreacion/baby_shower", "/recreacion/recreacion_infantil", "/recreacion/minitks", "/recreacion/refrigerios", "/recreacion/talleres_ludicos", "/recreacion/saltarines", "/colegios/chaquetas_prom", "/colegios/jean_day", "/colegios/dia_del_nino", "/colegios/fiestas_prom" ).permitAll()
                        .antMatchers("/admin*").hasRole("ADMIN")
                        .antMatchers("/coodinador*").access("hasRole('COORDINADOR') or hasRole('ADMIN')")
                        .antMatchers("/user*").access("hasRole('USER') or hasRole('ADMIN')")
                        .anyRequest().authenticated())
                .formLogin(login -> login
                        .loginPage("/login")
                        .permitAll()
                        .defaultSuccessUrl("/admin")
                        .failureUrl("/login?error=true")
                        .usernameParameter("username")
                        .passwordParameter("password"))
                .logout(logout -> logout
                        .permitAll()
                        .logoutSuccessUrl("/login?logout"));
    }

    //acá configuramos la encriptacion de las contraseñas
    BCryptPasswordEncoder bCryptPasswordEncoder;
    //Crea el encriptador de contraseñas	
    
    //@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        //este constructor del encriptador recibe un parametro de enteros
		bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
    //El numero 4 representa que tan fuerte quieres la encriptacion.
    //Se puede en un rango entre 4 y 31. 
    //Si no ponemos un numero el programa utilizara uno aleatoriamente cada vez que iniciemos la aplicacion, por lo cual las contrasenas encriptadas no funcionaran bien
        return bCryptPasswordEncoder;
    }
	
    @Autowired
    @Lazy
    UserDetailsServiceImpl userDetailsService;


    //en la configuracion global y de la manera en como vamos a autenticar los usuarios va a ser utilizando el coder (linea 87) y un servicio
    //Registra el service para usuarios y el encriptador de contrasena
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 
 
        // Setting Service to find User in the database.
        // And Setting PassswordEncoder
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());   
    }
}
