package com.task.business.service;

import com.task.business.dao.FlightInfoRepository;
import com.task.business.entity.FlightInfo;
import com.task.business.service.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlightInfoServiceImpl implements FlightInfoService{

    private final FlightInfoRepository flightInfoRepository;

    @Override
    public FlightInfo getFlightInfoById(Long id) {
        return flightInfoRepository.findById(id).orElseThrow(
                () -> new NotFoundException("FlightInfo not found")
        );
    }
}
