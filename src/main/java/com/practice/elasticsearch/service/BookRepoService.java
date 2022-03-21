package com.practice.elasticsearch.service;

import com.practice.elasticsearch.domain.ElasticBook;
import com.practice.elasticsearch.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookRepoService {

    @Autowired
    private BookRepository bookRepository;

    public BookRepoService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void createBookIndexBulk(final List<ElasticBook> elasticBooks) {
        bookRepository.saveAll(elasticBooks);
    }

    public void createBookIndex(final ElasticBook elasticBook) {
        bookRepository.save(elasticBook);
    }

}
