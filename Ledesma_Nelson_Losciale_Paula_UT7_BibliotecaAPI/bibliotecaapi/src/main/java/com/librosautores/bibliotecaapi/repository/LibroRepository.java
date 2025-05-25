package com.librosautores.bibliotecaapi.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.librosautores.bibliotecaapi.model.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {    
    // Métodos personalizados según las necesidades del servicio
    List<Libro> findByTituloContaining(String titulo);
    List<Libro> findByAnio(Integer anio);
    List<Libro> findByTituloContainingAndAnio(String titulo, Integer anio);
}