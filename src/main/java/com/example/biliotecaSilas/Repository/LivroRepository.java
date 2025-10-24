package com.example.biliotecaSilas.Repository;


import com.example.biliotecaSilas.Models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro,Long> {
}
