package com.librosautores.bibliotecaapi.service;

import com.librosautores.bibliotecaapi.model.Autor;
import com.librosautores.bibliotecaapi.model.Libro;
import com.librosautores.bibliotecaapi.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> findAll() {
        return autorRepository.findAll();
    }
    
    public Optional<Autor> findById(Long id) {
        return autorRepository.findById(id);
    }
    
    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }
    
    public List<Libro> findLibrosByAutorId(Long autorId) {
        Optional<Autor> autor = autorRepository.findById(autorId);
        return autor.map(Autor::getLibros).orElse(null);
    }
}