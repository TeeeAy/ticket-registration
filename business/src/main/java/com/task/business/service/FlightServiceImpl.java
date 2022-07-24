package com.task.business.service;

import com.task.business.dao.FlightRepository;
import com.task.business.entity.Flight;
import com.task.business.service.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService{

    private final FlightRepository flightRepository;

    @Override
    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Flight not found")
        );
    }
}
