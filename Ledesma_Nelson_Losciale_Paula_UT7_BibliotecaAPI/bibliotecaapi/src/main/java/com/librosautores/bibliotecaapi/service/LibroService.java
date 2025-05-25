package com.librosautores.bibliotecaapi.service;

import com.librosautores.bibliotecaapi.model.Libro;
import com.librosautores.bibliotecaapi.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    private final LibroRepository libroRepository;

    @Autowired
    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    public Optional<Libro> findById(Long id) {
        return libroRepository.findById(id);
    }

    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }

    public void deleteById(Long id) {
        libroRepository.deleteById(id);
    }

    public List<Libro> findByFilters(String titulo, Integer anio) {
        if (titulo != null && anio != null) {
            return libroRepository.findByTituloContainingAndAnio(titulo, anio);
        } else if (titulo != null) {
            return libroRepository.findByTituloContaining(titulo);
        } else if (anio != null) {
            return libroRepository.findByAnio(anio);
        } else {
            return libroRepository.findAll();
        }
    }
}