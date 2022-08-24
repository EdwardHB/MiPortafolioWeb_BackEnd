/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolioweb.ehb.Interface;

import com.portafolioweb.ehb.Entity.Persona;
import java.util.List;

/**
 *
 * @author eduen
 */
public interface IPersonaService {
   public List<Persona> getPersona();
   public void guardarPersona(Persona persona);
   public void eliminarPersona(Long id);
   public Persona encontrarPersona(Long id);
}
