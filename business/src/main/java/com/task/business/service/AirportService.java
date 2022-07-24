package com.task.business.service;

import com.task.business.entity.Airport;

public interface AirportService {

    void saveAirport(Airport airport);

    Airport getAirportById(Long id);

    void deleteAirportById(Long id);

}
