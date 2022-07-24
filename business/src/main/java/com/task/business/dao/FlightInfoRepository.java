package com.task.business.dao;

import com.task.business.entity.FlightInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightInfoRepository extends JpaRepository<FlightInfo, Long> {
}
