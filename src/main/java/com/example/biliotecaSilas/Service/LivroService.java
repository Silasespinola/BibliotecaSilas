package com.example.biliotecaSilas.Service;

import com.example.biliotecaSilas.Models.Livro;
import com.example.biliotecaSilas.Repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public LivroService() {
    }

    public Livro salvar(Livro livro) {
        return (Livro)this.livroRepository.save(livro);
    }

    public List<Livro> buscarTodos() {
        return this.livroRepository.findAll();
    }

    public Livro buscarPorId(Long id) {
        return (Livro)this.livroRepository.findById(id).get();
    }

    public Livro atualizar(Long id, Livro livro) {
        Optional<Livro> livroOptional = this.livroRepository.findById(id);
        if (livroOptional.isPresent()) {
            Livro livroExistente = (Livro)livroOptional.get();
            livroExistente.setTitulo(livro.getTitulo());
            livroExistente.setAutor(livro.getAutor());
            livroExistente.setAnoPublicacao(livro.getAnoPublicacao());
            return (Livro)this.livroRepository.save(livroExistente);
        } else {
            throw new RuntimeException("Livro não encontrado");
        }
    }

    public void deletar(Long id) {
        this.livroRepository.deleteById(id);
    }
}
