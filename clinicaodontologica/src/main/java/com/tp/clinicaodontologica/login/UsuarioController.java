package com.tp.clinicaodontologica.login;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {


    @GetMapping
    public String home(){
        return "<h1> Bienvenido</h1>";
    }

    @GetMapping("/user")
    public String usuario(){
        return "<h1>Bienvenido Usuario </h1>";
    }

    @GetMapping("/admin")
    public String admin(){
        return "<h1> Bienvenido Admin</h1>";
    }

}
