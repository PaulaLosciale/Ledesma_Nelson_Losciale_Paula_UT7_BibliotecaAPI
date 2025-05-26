package com.librosautores.bibliotecaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.librosautores.bibliotecaapi.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}