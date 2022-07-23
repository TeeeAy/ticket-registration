package com.task.business.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "flights")
@Getter
@Setter
@Builder(toBuilder = true, setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    @Id
    private Long id;

    private String flightNumber;

    @ManyToOne
    @JoinColumn(name="departure_airport_id", nullable=false)
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name="destination_airport_id", nullable=false)
    private Airport destinationAirport;



}
