package com.pdv.service;

import com.pdv.model.Usuario;
import com.pdv.model.UsuarioPrincipal;
import com.pdv.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();
   
    

    @Override
    public UserDetails loadUserByUsername(String nome) {
        Usuario usuario = usuarioRepository.findByUsername(nome);
        if (usuario == null) {
            throw new UnsupportedOperationException("Usuário Inexistente");
        }
        return new UsuarioPrincipal(usuario);
    }

    public Usuario save(Usuario usuario) {
        Usuario u = usuarioRepository.findByUsername(usuario.getUsername());
        if (u != null) {
            throw new UnsupportedOperationException("Usuário cadastrado");
        }
        usuario.setPassword(bcryptEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }
    
}
