package com.task.business.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "seats")
@Getter
@Setter
@Builder(toBuilder = true, setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
public class Seat {

    @Id
    @GeneratedValue
    private Long id;

    private String seatNumber;

    @ManyToOne
    @JoinColumn(name="plane_id", nullable=false)
    private Plane plane;

    @OneToMany(mappedBy = "seat")
    private List<Ticket> tickets;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    private Integer markupPercentage;


}
