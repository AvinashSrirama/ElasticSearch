package com.practice.elasticsearch.service;

import com.practice.elasticsearch.domain.ElasticBook;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class BookTemplateService {

    private static final String BOOK_INDEX = "book";

    private ElasticsearchOperations elasticsearchOperations;

    public BookTemplateService(ElasticsearchOperations elasticsearchOperations) {
        this.elasticsearchOperations = elasticsearchOperations;
    }

    public String createBookIndex(ElasticBook elasticBook) {

        IndexQuery indexQuery = new IndexQueryBuilder()
                .withId(elasticBook.getId().toString())
                .withObject(elasticBook).build();

        return elasticsearchOperations
                .index(indexQuery, IndexCoordinates.of(BOOK_INDEX));
    }

    public List<ElasticBook> getByBookName(String bookName) {
        QueryBuilder queryBuilder = QueryBuilders.matchQuery("bookname", bookName);

        Query searchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .build();

        SearchHits<ElasticBook> bookHits = elasticsearchOperations
                .search(searchQuery,
                        ElasticBook.class,
                        IndexCoordinates.of(BOOK_INDEX));

        return bookHits.get().map(SearchHit::getContent).collect(Collectors.toList());
    }
}
