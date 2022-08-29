/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolioweb.ehb.Security.Service;

import com.portafolioweb.ehb.Security.Entity.Usuario;
import com.portafolioweb.ehb.Security.Repository.IUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eduen
 */
@Service
@Transactional
public class UsuarioService {
    @Autowired
    IUsuarioRepository iUsuarioRepository;
    
    public Optional<Usuario> getByNombreDeUsuario(String nombreDeUsuario){
        return iUsuarioRepository.findByNombreDeUsuario(nombreDeUsuario);
    }
    
    public boolean existByNombreDeUsuario(String nombreDeUsuario){
        return iUsuarioRepository.existByNombreDeUsuardio(nombreDeUsuario);
    }
    
    public boolean existByCorreo(String correo){
        return iUsuarioRepository.existByCorreo(correo);
    }
    
    public void save(Usuario usuario){
        iUsuarioRepository.save(usuario);
    }
}
