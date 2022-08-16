package com.example.libraryproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LibraryController {
    @GetMapping("/library")
    String library() {
        return "library";
    }
}
