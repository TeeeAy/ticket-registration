package com.task.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "planes")
@Getter
@Setter
@Builder(toBuilder = true, setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
public class Plane {
    @Id
    @GeneratedValue
    private Long id;
    private String modelNumber;

    @OneToMany(mappedBy="plane")
    private Set<Seat> seats;

    @OneToMany(mappedBy="plane")
    private Set<Flight> flightInfos;


}
