package com.example.libraryproject.controller;

import com.example.libraryproject.model.Book;
import com.example.libraryproject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books")
    String books(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("delete-book")
    String books(int id) {
        bookRepository.deleteById(id);
        return "redirect:books";
    }

    @GetMapping("create-book")
    String create() {
        return "create-book";
    }

    @PostMapping("create-book")
    String create(Book book) {
        bookRepository.save(book);
        return "redirect:books";
    }

    @GetMapping("update-book")
    String update(Model model, int id) {
        Book book = bookRepository.findById(id).get();
        model.addAttribute("book", book);
        return "update-book";
    }

    @PostMapping("update-book")
    String update(Book book) {
        bookRepository.save(book);
        return "redirect:books";
    }
}
