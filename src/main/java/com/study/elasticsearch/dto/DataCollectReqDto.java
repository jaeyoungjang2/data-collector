package com.study.elasticsearch.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)

public class DataCollectReqDto {

    private String prodType;

    private String dataType;

    private String data;
}