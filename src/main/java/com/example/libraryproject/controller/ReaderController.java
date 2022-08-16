package com.example.libraryproject.controller;

import com.example.libraryproject.model.Book;
import com.example.libraryproject.model.Reader;
import com.example.libraryproject.repository.BookRepository;
import com.example.libraryproject.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ReaderController {
    @Autowired
    ReaderRepository readerRepository;
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/reader")
    String readers(Model model) {
        List<Reader> readers = readerRepository.findAll();
        model.addAttribute("reader", readers);
        return "reader";
    }

    @GetMapping("delete-reader")
    String delete(int id) {
        readerRepository.deleteById(id);
        return "redirect:reader";
    }

    @GetMapping("create-reader")
    String create() {
        return "create-reader";
    }

    @PostMapping("create-reader")
    String create(Reader reader) {
        readerRepository.save(reader);
        return "redirect:reader";
    }

    @GetMapping("update-reader")
    String update(Model model, int id) {
        Reader reader = readerRepository.findById(id).get();
        model.addAttribute("reader", reader);
        return "update-reader";
    }

    @PostMapping("update-reader")
    String update(Reader reader) {
        readerRepository.save(reader);
        return "redirect:reader";
    }
}
