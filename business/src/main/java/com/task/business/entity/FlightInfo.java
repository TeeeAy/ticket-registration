package com.task.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.Duration;
import java.util.Set;

@Entity
@Table(name = "flightInfos")
@Getter
@Setter
@Builder(toBuilder = true, setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
public class FlightInfo {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="departure_airport_id", nullable=false)
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name="destination_airport_id", nullable=false)
    private Airport destinationAirport;

    private Duration flightDuration;

    private Integer price;

    @OneToMany(mappedBy="flightInfo")
    private Set<Flight> flights;

}
