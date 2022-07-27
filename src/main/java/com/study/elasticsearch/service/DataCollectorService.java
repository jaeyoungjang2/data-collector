package com.study.elasticsearch.service;

import com.study.elasticsearch.common.aop.PublishDataCollectEvent;
import com.study.elasticsearch.common.event.DataCollectEvent;
import com.study.elasticsearch.dto.CollectedDataDto;
import com.study.elasticsearch.dto.DataCollectReqDto;
import com.study.elasticsearch.dto.DataCollectRespDto;
import com.study.elasticsearch.repository.InMemoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h1>데이터 수집 서비스</h1>
 * {@link DataCollectReqDto 수집 요청 받은 데이터}를 가공해 {@link InMemoryRepository 임시 저장소}에 저장하고, {@link CollectedDataDto 수집 데이터}를 가져옵니다.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DataCollectorService {

    private final InMemoryRepository inMemoryRepository;

    /**
     * 요청 받은 데이터를 임시 저장소에 저장합니다.
     *
     * @param dataCollectReqDto 수집 요청 데이터
     * @return 데이터 수집 결과
     * @see PublishDataCollectEvent
     * @see io.hoon.datacollector.common.aop.AopAdvisor
     */
    @PublishDataCollectEvent
    public DataCollectRespDto collectData(DataCollectReqDto dataCollectReqDto) throws InterruptedException {
        // 데이터 임시 저장
        inMemoryRepository.save(dataCollectReqDto);
        return new DataCollectRespDto()
                .setProdType(dataCollectReqDto.getProdType())
                .setDataType(dataCollectReqDto.getDataType())
                .setSuccess(true);
    }

    public List<CollectedDataDto> getData() {
        return inMemoryRepository.getData();
    }
}