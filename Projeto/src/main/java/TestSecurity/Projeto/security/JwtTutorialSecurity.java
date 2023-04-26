package TestSecurity.Projeto.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class JwtTutorialSecurity {

    // Configurar spring security. Este método diz ao spring security como aceder aos dados dos utilizadores quando os
    // nomes das tabelas nao sao default (o default é haver 2 tabelas, uma chamada "users" e outra chamada "authorities")
    // neste caso estão a ser utilizadas tabelas que até têm os nomes predefinidos mas pode ser utilizado com outros nomes
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select username,password,enabled from users where username = ?");


        // define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select username,authority from authorities where username = ?");

        return jdbcUserDetailsManager;
    }

    // Este método diz ao spring security para utilizar os dados dos utilizadores guardados na base de dados.
    // Só funciona se as tabelas dos utilizadores e das suas permissões/roles/authorities tiverem os nomes
    // "users" e "authorities", sendo que a tabela "users" tem obrigatoriamente de ter os campos "username", "password"
    // e "enabled" e a tabela "authorities" tem obrigatoriamente de ter os campos "username" e "authority" (o campo
    // "authority" tem de começar com "ROLE_", por exemplo "ROLE_ADMIN".
//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(configurer ->
                {
                    try {
                        configurer
                                .requestMatchers(HttpMethod.GET, "/bloqueada").hasRole("ADMIN")
                                .requestMatchers("/user").hasRole("USER")
                                .anyRequest().permitAll()
                                .and()
                                .formLogin()
                                .loginPage("/loginForm")
                                .loginProcessingUrl("/authenticateTheUser") // este URL já está incluido no spring security. não é necessario fazer um controller para ele.
                                .permitAll()
                                .and()
                                .logout()
                                .logoutUrl("/logout") // set the logout URL to "/logout"
                                .logoutSuccessUrl("/loginForm") // set the redirect URL after logout to "/login"
//                                .invalidateHttpSession(true) // invalidate the user's HTTP session after logout
//                                .deleteCookies("JSESSIONID") // delete the JSESSIONID cookie after logout
                                .permitAll();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });

        // para utilizar basic authentication
        http.httpBasic();

        http.csrf().disable();

        return http.build();
    }
}