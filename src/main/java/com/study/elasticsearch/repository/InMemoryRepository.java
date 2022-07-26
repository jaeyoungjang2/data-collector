package com.study.elasticsearch.repository;


import com.study.elasticsearch.dto.CollectedDataDto;
import com.study.elasticsearch.dto.DataCollectReqDto;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
/**
 * <h1>메모리 임시 저장소</h1>
 * 수집 요청 받은 데이터를 메모리에 임시로 저장하는 클래스
 */
@Component
public class InMemoryRepository {

    private Queue<CollectedDataDto> repository = new LinkedBlockingQueue<>();

    public boolean save(DataCollectReqDto dataCollectReqDto) {
        return this.repository.offer(new CollectedDataDto()
                .setProdType(dataCollectReqDto.getProdType())
                .setDataType(dataCollectReqDto.getDataType())
                .setData(dataCollectReqDto.getData()));
    }

    /**
     * 임시 저장된 모든 데이터를 조회합니다.
     * @return 임시 저장된 모든 {@link CollectedDataDto 수집 데이터}
     */
    public List<CollectedDataDto> getData() {
        List<CollectedDataDto> rtn = new ArrayList<>();
        ((LinkedBlockingQueue) this.repository).drainTo(rtn);
        return rtn;
    }
}