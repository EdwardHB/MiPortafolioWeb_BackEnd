/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolioweb.ehb.Service;

import com.portafolioweb.ehb.Entity.Persona;
import com.portafolioweb.ehb.Interface.IPersonaService;
import com.portafolioweb.ehb.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eduen
 */
@Service
public class ImpPersonaService implements IPersonaService{
    @Autowired IPersonaRepository ipersonaRepository;

    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = ipersonaRepository.findAll();
        return persona;
    }

    @Override
    public void guardarPersona(Persona persona) {
        ipersonaRepository.save(persona);
    }

    @Override
    public void eliminarPersona(Long id) {
        ipersonaRepository.deleteById(id);
    }

    @Override
    public Persona encontrarPersona(Long id) {
        Persona persona = ipersonaRepository.findById(id).orElse(null);
        return persona;
    }
    
}

