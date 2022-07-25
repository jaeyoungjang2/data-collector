package com.study.elasticsearch.test;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


//@RestController
//@RequiredArgsConstructor
//public class TestElasticSearchController {
//
//    private final TestElasticSearchRepository testElasticSearchRepository;
//
//    @PostMapping("/_indexing")
//    public void indexing(@RequestBody TestElasticSearchDto testElasticSearchDto) {
//        TestElasticSearchDomain testElasticSearchDomain = new TestElasticSearchDomain(testElasticSearchDto);
//        testElasticSearchRepository.save(testElasticSearchDomain);
//    }
//}
