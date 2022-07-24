package com.task.business.transformer;

import com.task.business.dao.FlightInfoRepository;
import com.task.business.dto.FlightDto;
import com.task.business.entity.Flight;
import com.task.business.service.FlightInfoService;
import com.task.business.service.PlaneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FlightTransformer {

    private final FlightInfoService flightInfoService;

    private final PlaneService planeService;

    public Flight transform(FlightDto flightDto) {
        return Flight.builder()
                .withFlightNumber(flightDto.getFlightNumber())
                .withDepartureTime(flightDto.getDepartureTime())
                .withPlane(planeService.getPlaneById(flightDto.getPlaneId()))
                .withFlightInfo(flightInfoService.getFlightInfoById(
                        flightDto.getFlightInfoId()))
                .build();
    }

    public FlightDto transform(Flight flight) {
        return FlightDto.builder().build();
    }
}
