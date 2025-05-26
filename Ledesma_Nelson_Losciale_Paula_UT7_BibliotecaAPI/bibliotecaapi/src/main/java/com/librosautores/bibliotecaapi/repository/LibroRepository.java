package com.librosautores.bibliotecaapi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.librosautores.bibliotecaapi.model.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByTituloContaining(String titulo);
    List<Libro> findByAnioPublicacion(Integer anioPublicacion);
    List<Libro> findByTituloContainingAndAnioPublicacion(String titulo, Integer anioPublicacion);
    
    // Métodos para ordenación
    List<Libro> findAllByOrderByTituloAsc();
    List<Libro> findAllByOrderByTituloDesc();
    List<Libro> findAllByOrderByAnioPublicacionAsc();
    List<Libro> findAllByOrderByAnioPublicacionDesc();
}