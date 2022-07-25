package com.study.elasticsearch.test;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Document(indexName = "domainname")
public class TestElasticSearchDomain {
    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String type1;

    @Field(type = FieldType.Text)
    private String type2;

    private List<String> keywords;

    public TestElasticSearchDomain(TestElasticSearchDto testElasticSearchDto) {
        this.type1 = testElasticSearchDto.getType1();
        this.type2 = testElasticSearchDto.getType2();
    }
}
