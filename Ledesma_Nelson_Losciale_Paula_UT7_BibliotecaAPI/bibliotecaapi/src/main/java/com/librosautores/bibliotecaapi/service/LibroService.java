package com.librosautores.bibliotecaapi.service;

import com.librosautores.bibliotecaapi.model.Libro;
import com.librosautores.bibliotecaapi.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
    private final LibroRepository libroRepository;

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

    public List<Libro> findByFilters(String titulo, Integer anio, String sortBy, String order) {
        List<Libro> libros;
        
        if (titulo != null && anio != null) {
            libros = libroRepository.findByTituloContainingAndAnioPublicacion(titulo, anio);
        } else if (titulo != null) {
            libros = libroRepository.findByTituloContaining(titulo);
        } else if (anio != null) {
            libros = libroRepository.findByAnioPublicacion(anio);
        } else {
            libros = libroRepository.findAll();
        }

        // Lógica de ordenación
        if (sortBy != null && order != null) {
            switch (sortBy) {
                case "titulo":
                    libros = order.equalsIgnoreCase("desc") ? 
                            libroRepository.findAllByOrderByTituloDesc() : 
                            libroRepository.findAllByOrderByTituloAsc();
                    break;
                case "anioPublicacion":
                    libros = order.equalsIgnoreCase("desc") ? 
                            libroRepository.findAllByOrderByAnioPublicacionDesc() : 
                            libroRepository.findAllByOrderByAnioPublicacionAsc();
                    break;
            }
        }
        
        return libros;
    }
}