/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolioweb.ehb.Security.Controller;

import com.portafolioweb.ehb.Security.Entity.Rol;
import com.portafolioweb.ehb.Security.Entity.Usuario;
import com.portafolioweb.ehb.Security.Enums.RolNombre;
import com.portafolioweb.ehb.Security.Service.RolService;
import com.portafolioweb.ehb.Security.Service.UsuarioService;
import com.portafolioweb.ehb.Security.jwt.JwtProvider;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author eduen
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;
    
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
       if(bindingResult.hasErrors())
           return new ResponseEntity(new Mensaje("Email Invalido"),HttpStatus.BAD_REQUEST);
       if(usuarioService.existByNombreDeUsuario(nombreDeUsuario.getNombreDeUsuario()))
           return new ResponseEntity(new Mensaje("El nombre de usuario ya existe"),HttpStatus.BAD_REQUEST);
       if(usuarioService.existByCorreo(nombreDeUsuario.getCorreo()))
           return new ResponseEntity(new Mensaje("El Correo electronico ya existe"),HttpStatus.BAD_REQUEST);
       
       Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreDeUsuario(),nuevoUsuario.getCorreo(), passwordEncoder.encode(nuevoUsuario.getContra()));
       Set<Rol> roles = new HashSet<>();
       roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
       
       if(nuevoUsuario.getRoles().contains("Admin"))
           roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
       usuario.setRoles(roles);
       usuarioService.save(usuario);
       
       return new ResponseEntity(new Mensaje("Usuario guardado"),HttpStatus.CREATED);
    }
    
    public ResponseEntity<jwtDTO> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos invalidos"),HttpStatus.BAD_REQUEST);
        Authentication
    }
}
