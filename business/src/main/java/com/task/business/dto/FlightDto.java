package com.task.business.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.task.business.entity.FlightInfo;
import com.task.business.entity.Plane;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true, setterPrefix = "with")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FlightDto {

    private String flightNumber;

    private Long flightInfoId;

    private Long planeId;

    private LocalDateTime departureTime;

    private Long flightId;

}
