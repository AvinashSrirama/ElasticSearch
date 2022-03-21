package com.practice.elasticsearch.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.elasticsearch.common.geo.GeoPoint;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    @JsonProperty(value ="id")
    private String id;

    @JsonProperty(value ="bookname")
    private String bookName;

    @JsonProperty(value ="authorname")
    private String authorName;

    @JsonProperty(value ="genre")
    private String genre;

    @JsonProperty(value ="city")
    private String city;

    @JsonProperty(value ="libraryname")
    private String libraryName;

    @JsonProperty(value ="year")
    private Integer year;

    @JsonProperty(value ="location")
    private String location;

}
