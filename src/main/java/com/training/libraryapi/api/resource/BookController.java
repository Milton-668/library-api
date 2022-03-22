package com.training.libraryapi.api.resource;

import com.training.libraryapi.dto.BookDTO;
import com.training.libraryapi.model.entity.Book;
import com.training.libraryapi.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Esse método é utilizado para criar um book
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO create(@RequestBody BookDTO dto) {

        /**Aqui nós temos um caso que é chegado um Dto, passa para a entitidade
         * para acessar o banco de dados e retorna os dados da entidade em forma
         * dto. */
        Book entity = Book.builder()
                .author(dto.getAuthor())
                .title(dto.getAuthor())
                .isbn(dto.getIsbn())
                .build();

        entity = bookService.save(entity);

        BookDTO bookDTO = BookDTO.builder()
                .id(entity.getId())
                .author(entity.getAuthor())
                .title(entity.getTitle())
                .isbn(entity.getIsbn())
                .build();

        return bookDTO;
    }
}
