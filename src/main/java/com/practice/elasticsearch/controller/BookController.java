package com.practice.elasticsearch.controller;

import com.practice.elasticsearch.domain.BookDto;
import com.practice.elasticsearch.domain.ElasticBook;
import com.practice.elasticsearch.service.BookRepoService;
import com.practice.elasticsearch.service.BookTemplateService;
import org.elasticsearch.common.geo.GeoPoint;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private BookRepoService bookRepoService;

    private BookTemplateService bookTemplateService;

    public BookController(BookRepoService bookRepoService, BookTemplateService bookTemplateService) {
        this.bookRepoService = bookRepoService;
        this.bookTemplateService = bookTemplateService;
    }

    @PostMapping(value="/savebookusingrepo", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> saveBookUsingRepo(@RequestBody BookDto bookDto){

        GeoPoint geoPoint = new GeoPoint(40.641766, -73.780968);
        ElasticBook elasticBook = ElasticBook.builder().bookname(bookDto.getBookName()).authorname(bookDto.getAuthorName())
                .city(bookDto.getCity()).genre(bookDto.getGenre()).libraryname(bookDto.getLibraryName())
                .location(geoPoint).year(bookDto.getYear()).id(bookDto.getId()).build();

        bookRepoService.createBookIndex(elasticBook);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);

    }

    @PostMapping(value="/savebookusingtemplate", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> saveBookUsingTemplate(@RequestBody BookDto bookDto){

        GeoPoint geoPoint = new GeoPoint(40.641766, -73.780968);
        ElasticBook elasticBook = ElasticBook.builder().bookname(bookDto.getBookName()).authorname(bookDto.getAuthorName())
                .city(bookDto.getCity()).genre(bookDto.getGenre()).libraryname(bookDto.getLibraryName())
                .location(geoPoint).year(bookDto.getYear()).id(bookDto.getId()).build();

        bookTemplateService.createBookIndex(elasticBook);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);

    }

    @GetMapping(value="/getbybookname/{bookName}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ElasticBook>> getByBookName(@PathVariable String bookName){

        return new ResponseEntity<>(bookTemplateService.getByBookName(bookName), HttpStatus.OK);
    }


}
