package com.tp.clinicaodontologica.login;
import com.tp.clinicaodontologica.model.Rol;
import com.tp.clinicaodontologica.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements ApplicationRunner {

    final private IUsuarioRepository usuarioRepository;

    @Autowired
    public DataLoader(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String password = passwordEncoder.encode("pass1234");
        String password2 = passwordEncoder.encode("1234pass");

        usuarioRepository.save(new Usuario("clara", password, "clara@gmail.com", Rol.USER));
        usuarioRepository.save(new Usuario("prueba", password2,"admin@gmail.com", Rol.ADMIN));

    }
}
