package com.task.business.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "flights")
@Getter
@Setter
@Builder(toBuilder = true, setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    @Id
    @GeneratedValue
    private Long id;

    private String flightNumber;

    @ManyToOne
    @JoinColumn(name="flight_info_id", nullable=false)
    private FlightInfo flightInfo;

    @ManyToOne
    @JoinColumn(name="plane_id", nullable=false)
    private Plane plane;

    private LocalDateTime departureTime;

    @OneToMany(mappedBy = "flight")
    private List<Ticket> tickets;


}
