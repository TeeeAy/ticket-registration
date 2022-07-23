package com.task.business.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "airports")
@Getter
@Setter
@Builder(toBuilder = true, setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
public class Airport {
    @Id
    private Long id;
    private String name;
    private String country;
    private String city;

    @OneToMany(cascade = CascadeType.ALL,mappedBy ="departureAirport")
    private List<Flight> ratesIC;

    @OneToMany(cascade = CascadeType.ALL,mappedBy ="destinationAirport")
    private List<Flight> ratesOC;
}
