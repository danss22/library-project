package com.example.libraryproject.controller;

import com.example.libraryproject.model.Book;
import com.example.libraryproject.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {
    @Autowired
    SearchRepository searchRepository;

    @GetMapping("search")
    public String search(@RequestParam("author") String author, Model model) {
        List<Book> byAuthor = searchRepository.findByAuthor(author);
        model.addAttribute("books", byAuthor);
        return "search";
    }

    @PostMapping("search")
    public String search1(@RequestParam("author") String author, Model model) {
        List<Book> byAuthor = searchRepository.findByAuthor(author);
        model.addAttribute("books", byAuthor);
        return "search";
    }
}

