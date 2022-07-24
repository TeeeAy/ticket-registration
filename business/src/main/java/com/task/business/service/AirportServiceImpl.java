package com.task.business.service;

import com.task.business.dao.AirportRepository;
import com.task.business.entity.Airport;
import com.task.business.service.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;

    @Override
    public void saveAirport(Airport airport) {
        airportRepository.save(airport);
    }

    @Override
    public Airport getAirportById(Long id) {
        return airportRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Airport not found")
        );
    }

    @Override
    public void deleteAirportById(Long id) {
        airportRepository.deleteById(id);
    }
}
