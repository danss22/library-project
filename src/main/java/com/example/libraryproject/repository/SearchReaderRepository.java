package com.example.libraryproject.repository;

import com.example.libraryproject.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SearchReaderRepository extends JpaRepository<Reader, Integer> {
    List<Reader> findBySurName(String surName);
}
