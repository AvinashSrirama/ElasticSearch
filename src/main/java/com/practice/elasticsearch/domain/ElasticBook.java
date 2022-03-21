package com.practice.elasticsearch.domain;

import lombok.*;
import org.elasticsearch.common.geo.GeoPoint;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.GeoPointField;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "book")
public class ElasticBook {

    @Id
    private String id;

    @Field(type = FieldType.Text, name = "bookname")
    private String bookname;

    @Field(type = FieldType.Text, name = "authorname")
    private String authorname;

    @Field(type = FieldType.Text, name = "genre")
    private String genre;

    @Field(type = FieldType.Text, name = "city")
    private String city;

    @Field(type = FieldType.Text, name = "libraryname")
    private String libraryname;

    @Field(type = FieldType.Integer, name = "year")
    private Integer year;

    @Field(type = FieldType.Text, name = "location")
    @GeoPointField
    private GeoPoint location;

}
