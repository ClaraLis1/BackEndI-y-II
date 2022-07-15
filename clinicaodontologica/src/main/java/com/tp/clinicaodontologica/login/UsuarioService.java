package com.tp.clinicaodontologica.login;
import com.tp.clinicaodontologica.login.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    private final IUsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
    }
}
