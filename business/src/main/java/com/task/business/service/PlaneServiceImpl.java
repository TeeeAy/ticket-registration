package com.task.business.service;

import com.task.business.dao.PlaneRepository;
import com.task.business.entity.Plane;
import com.task.business.service.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaneServiceImpl implements PlaneService{

    private final PlaneRepository planeRepository;

    @Override
    public Plane getPlaneById(Long id) {
        return planeRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Plane not found")
        );
    }
}

