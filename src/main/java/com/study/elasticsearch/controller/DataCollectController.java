package com.study.elasticsearch.controller;

import com.study.elasticsearch.common.dto.CommonResponse;
import com.study.elasticsearch.dto.DataCollectReqDto;
import com.study.elasticsearch.dto.DataCollectRespDto;
import com.study.elasticsearch.service.DataCollectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Tag(name = "데이터 수집")
@RestController
@RequestMapping("/data")
@RequiredArgsConstructor
public class DataCollectController {

    private final DataCollectorService dataCollectorService;

    @PostMapping
    //@Operation(summary = "데이터 수집 요청")

    public CommonResponse<DataCollectRespDto> collectRequest(@RequestBody DataCollectReqDto dataCollectReqDto) throws InterruptedException {
        return CommonResponse.of(dataCollectorService.collectData(dataCollectReqDto));
    }
}



/*
@Tag(name = "데이터 수집")
@RestController
@RequestMapping("/data")
@RequiredArgsConstructor
public class DataCollectController {

    private final DataCollectorService dataCollectorService;

    @PostMapping
    @Operation(summary = "데이터 수집 요청")
    public CommonResponse<DataCollectRespDto> collectRequest(@Parameter(name = "데이터 수집 요청 DTO", required = true)
                                                             @RequestBody
                                                             @Valid DataCollectReqDto dataCollectReqDto) {
        return CommonResponse.of(dataCollectorService.collectData(dataCollectReqDto));
    }
}*/
