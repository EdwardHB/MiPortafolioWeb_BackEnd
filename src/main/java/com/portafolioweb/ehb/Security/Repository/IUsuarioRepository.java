/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolioweb.ehb.Security.Repository;

import com.portafolioweb.ehb.Security.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author eduen
 */
@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findByNombreDeUsuario(String nombreDeUsuario);
    boolean existByNombreDeUsuardio(String nombreDeUsuario);
    boolean existByCorreo(String correo);
}
