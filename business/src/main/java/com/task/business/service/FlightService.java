package com.task.business.service;

import com.task.business.entity.Flight;

public interface FlightService  {

    Flight saveFlight(Flight flight);

    Flight getFlightById(Long id);
}
