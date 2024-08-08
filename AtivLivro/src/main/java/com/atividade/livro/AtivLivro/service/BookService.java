package com.atividade.livro.AtivLivro.service;

import com.atividade.livro.AtivLivro.model.BookModel;
import com.atividade.livro.AtivLivro.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookModel> findByGenre() {
        return bookRepository.findByGenre(genre);
    }
}
