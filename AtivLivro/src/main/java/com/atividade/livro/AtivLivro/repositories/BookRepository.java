package com.atividade.livro.AtivLivro.repositories;

import com.atividade.livro.AtivLivro.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<BookModel, UUID> {
    List<BookModel> findByGenre(String genre);
}
