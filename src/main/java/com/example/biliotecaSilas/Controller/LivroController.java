package com.example.biliotecaSilas.Controller;

import com.example.biliotecaSilas.Models.Livro;
import com.example.biliotecaSilas.Service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        path = {"/livros"}
)
public class LivroController {
    @Autowired
    private LivroService livroService;

    public LivroController() {
    }

    @GetMapping
    public List<Livro> buscarTodos() {
        return this.livroService.buscarTodos();
    }

    @GetMapping({"/{id}"})
    public Livro buscarPorId(@PathVariable Long id) {
        return this.livroService.buscarPorId(id);
    }

    @PostMapping
    public Livro salvar(@RequestBody Livro livro) {
        return this.livroService.salvar(livro);
    }

    @DeleteMapping({"/{id}"})
    public void deletar(@PathVariable Long id) {
        this.livroService.deletar(id);
    }

    @PutMapping({"/{id}"})
    public Livro atualizar(@PathVariable Long id, @RequestBody Livro livroAtualizado) {
        return this.livroService.atualizar(id, livroAtualizado);
    }
}

