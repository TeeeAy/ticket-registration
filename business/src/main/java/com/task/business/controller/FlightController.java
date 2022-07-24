package com.task.business.controller;

import com.task.business.dto.FlightDto;
import com.task.business.entity.Flight;
import com.task.business.service.FlightService;
import com.task.business.service.TicketService;
import com.task.business.transformer.FlightTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/flight")
@RequiredArgsConstructor
public class FlightController {

    private final FlightTransformer flightTransformer;

    private final TicketService ticketService;

    private final FlightService flightService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("create")
    public FlightDto createFlight(@Valid @RequestBody FlightDto flightRequestDto){
        Flight flight = flightTransformer.transform(flightRequestDto);
        return flightTransformer.transform(flightService.saveFlight(flight));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("generate/tickets/{id}")
    public ResponseEntity<String> generateTicketsForFlight(@Valid @PathVariable Long id){
        ticketService.generateTicketsForFlight(flightService.getFlightById(id));
        return ResponseEntity.ok("Tickets generated successfully");
    }


}
