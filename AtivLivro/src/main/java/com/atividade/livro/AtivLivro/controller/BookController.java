package com.atividade.livro.AtivLivro.controller;

import com.atividade.livro.AtivLivro.dtos.BookDto;
import com.atividade.livro.AtivLivro.model.BookModel;
import com.atividade.livro.AtivLivro.repositories.BookRepository;
import jakarta.persistence.Entity;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping
    public ResponseEntity<List<BookModel>> getAllBooks (){
        return ResponseEntity.status(HttpStatus.OK).body(bookRepository.findAll());
    }

    @GetMapping("/{genre}")
    public ResponseEntity<List<BookModel>> getBookByGenre (@PathVariable(value = "genre") String genre){
        return ResponseEntity.status(HttpStatus.OK).body(bookRepository.findByGenre());
    }

    @PostMapping
    public ResponseEntity<BookModel> addBook(@RequestBody @Valid BookDto bookDto){
        var bookModel =  new BookModel();
        BeanUtils.copyProperties(bookDto, bookModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookRepository.save(bookModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateBook(@PathVariable(value = "id") UUID id, @RequestBody @Valid BookDto bookDto){
        Optional<BookModel> bookO = bookRepository.findById(id);
        if(bookO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found!");
        }else {
            var bookModel = bookO.get();
            BeanUtils.copyProperties(bookDto, bookModel);
            return ResponseEntity.status(HttpStatus.OK).body(bookRepository.save(bookModel));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value = "id") UUID id){
        Optional<BookModel> bookO = bookRepository.findById(id);
        if(bookO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found!");
        }else {
            bookRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Book deleted!");
        }
    }

}
