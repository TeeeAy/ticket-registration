package com.task.business.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.task.business.entity.FlightInfo;
import com.task.business.entity.Plane;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true, setterPrefix = "with")
public class FlightDto {

    private String flightNumber;

    private Long flightInfoId;

    private Long planeId;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime departureTime;

    private FlightInfo flightInfo;

    private Plane plane;


}
