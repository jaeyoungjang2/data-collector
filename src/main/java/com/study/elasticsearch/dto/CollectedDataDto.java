package com.study.elasticsearch.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.ZonedDateTime;

@Data
@Accessors(chain = true)
public class CollectedDataDto {
    private String prodType;
    private String dataType;
    private String data;
    private ZonedDateTime collectedDateTime = ZonedDateTime.now();
}

