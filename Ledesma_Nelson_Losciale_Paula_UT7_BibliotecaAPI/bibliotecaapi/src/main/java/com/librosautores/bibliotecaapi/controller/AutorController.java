package com.librosautores.bibliotecaapi.controller;

import com.librosautores.bibliotecaapi.model.Autor;
import com.librosautores.bibliotecaapi.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/autores")
public class AutorController {
    @Autowired
    private AutorService autorService;

    @GetMapping
    public List<Autor> getAllAutores() {
        return autorService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Autor> getAutorById(@PathVariable Long id) {
        return autorService.findById(id);
    }

    @PostMapping
    public Autor createAutor(@RequestBody Autor autor) {
        return autorService.save(autor);
    }
}