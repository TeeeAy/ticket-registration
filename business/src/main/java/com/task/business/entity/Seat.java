package com.task.business.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "seats")
@Getter
@Setter
@Builder(toBuilder = true, setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
public class Seat {

    @Id
    private Long id;

    private String seatNumber;

    @ManyToOne
    @JoinColumn(name="plane_id", nullable=false)
    private Plane plane;


}
