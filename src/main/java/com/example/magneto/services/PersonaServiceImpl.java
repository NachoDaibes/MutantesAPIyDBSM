package com.example.magneto.services;

import com.example.magneto.Repositories.BaseRepository;
import com.example.magneto.entities.Persona;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona,Long> implements PersonaService{

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository) {
        super(baseRepository);
    }
}
