package com.practice.elasticsearch.repositories;

import com.practice.elasticsearch.domain.ElasticBook;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends ElasticsearchRepository<ElasticBook, String> {

}
