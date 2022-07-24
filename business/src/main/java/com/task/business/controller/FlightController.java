package com.task.business.controller;

import com.task.business.dto.FlightDto;
import com.task.business.entity.Flight;
import com.task.business.service.FlightService;
import com.task.business.transformer.FlightTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/flight")
@RequiredArgsConstructor
public class FlightController {

    private final FlightTransformer flightTransformer;

    private final FlightService flightService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("create")
    public FlightDto createFlight(@Valid @RequestBody FlightDto flightRequestDto){
        Flight flight = flightTransformer.transform(flightRequestDto);
        return flightTransformer.transform(flightService.saveFlight(flight));
    }

}
