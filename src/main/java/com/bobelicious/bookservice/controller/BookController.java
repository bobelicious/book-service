package com.bobelicious.bookservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bobelicious.bookservice.model.Book;
import com.bobelicious.bookservice.proxy.CambioProxy;
import com.bobelicious.bookservice.repository.BookRepository;

@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private Environment environment;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CambioProxy cambioProxy;

    @GetMapping("/{id}/{currency}")
    public Book findBook(@PathVariable Long id, @PathVariable String currency) {
        var port = environment.getProperty("local.server.port");
        var book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        var cambio  = cambioProxy.getCambio(book.getPrice(), "USD", currency);
        /*HashMap<String, String> params = new HashMap<>();
        params.put("amount", book.getPrice().toString());
        params.put("from","USD");
        params.put("to", currency);
        var cambio = new RestTemplate().getForEntity("http://localhost:8000/cambio-service/{amount}/{from}/{to}", Cambio.class,
                params);*/
        book.setEnvironment(port + "FEIGN");
        book.setPrice(cambio.getConvertedValue());
        return book;
    }
}
