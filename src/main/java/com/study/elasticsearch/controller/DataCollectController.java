package com.study.elasticsearch.controller;

import com.study.elasticsearch.common.CommonResponse;
import com.study.elasticsearch.dto.DataCollectReqDto;
import com.study.elasticsearch.dto.DataCollectRespDto;
import com.study.elasticsearch.repository.InMemoryRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class DataCollectController {
    @PostMapping
    public CommonResponse<DataCollectRespDto> collectRequest(@RequestBody DataCollectReqDto dataCollectReqDto) {
        InMemoryRepository.save(dataCollectReqDto);
        return CommonResponse.of(new DataCollectRespDto());
    }
}
