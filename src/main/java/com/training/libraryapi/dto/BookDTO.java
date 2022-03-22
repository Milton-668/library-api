package com.training.libraryapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    /*Nós utilizamos um DTO para que ele crie um Json de entrada e saída nas interações
    * com o cliente para que não seja exposto a camada mais interna da aplicação e seus atributos.*/
    private Long id;
    private String title;
    private String author;
    private String isbn;
}
