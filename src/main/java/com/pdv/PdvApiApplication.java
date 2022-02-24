package com.pdv;

import com.pdv.model.Usuario;
import com.pdv.repository.UsuarioRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PdvApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PdvApiApplication.class, args);
    }

    @Bean
    ApplicationRunner init(UsuarioRepository usuarioRepository) {
        BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();
        Usuario usuario = new Usuario();
        usuario.setUsername("admin");
        usuario.setPassword(bcryptEncoder.encode("admin"));
        if (usuarioRepository.findByUsername("admin").getUsername() == null) {
            usuarioRepository.save(usuario);
        }

        return null;
    }

}
