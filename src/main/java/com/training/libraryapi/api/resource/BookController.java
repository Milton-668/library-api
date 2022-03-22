package com.training.libraryapi.api.resource;

import com.training.libraryapi.dto.BookDTO;
import com.training.libraryapi.model.entity.Book;
import com.training.libraryapi.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService bookService;
    private ModelMapper modelMapper;

    public BookController(BookService bookService, ModelMapper modelMapper) {
        this.bookService = bookService;
        this.modelMapper = modelMapper;
    }

    /**
     * Esse método é utilizado para criar um book
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO create(@RequestBody BookDTO dto) {
        /**Aqui nós temos um caso de conversão entre objetos, onde recebemos um dto
         * e o convertemos via modelMapper para a o objeto de entidade Book para que
         * seja feito as transações*/
        Book entity = modelMapper.map(dto, Book.class);
        /**Aqui é feito o salvamento dentro de bookService */
        entity = bookService.save(entity);
        /**Aqui é convetido os valores da entitidade para um um DTO novamente para que seja
         * entregue um Json com a resposta evitando a exposição do dominio.*/
        BookDTO responseDto = modelMapper.map(entity, BookDTO.class);

        return responseDto;
    }
}
