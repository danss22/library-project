package com.example.libraryproject.controller;

import com.example.libraryproject.model.Reader;
import com.example.libraryproject.repository.SearchReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchReaderController {
    @Autowired
    SearchReaderRepository searchReaderRepository;

    @GetMapping("search-reader")
    public String search_reader(@RequestParam("surName") String surName, Model model) {
        List<Reader> byReader = searchReaderRepository.findBySurName(surName);
        model.addAttribute("reader", byReader);
        return "search-reader";
    }

    @PostMapping("search-reader")
    public String search_reader1(@RequestParam("surName") String surName, Model model) {
        List<Reader> byReader = searchReaderRepository.findBySurName(surName);
        model.addAttribute("reader", byReader);
        return "search-reader";
    }
}
