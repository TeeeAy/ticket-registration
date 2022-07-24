package com.task.business.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
@Getter
@Setter
@Builder(toBuilder = true, setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="flight_id", nullable=false)
    private Flight flight;

    @ManyToOne
    @JoinColumn(name="seat_id", nullable=false)
    private Seat seat;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Builder.Default
    private boolean isAvailable = true;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private RefundStatus refundStatus = RefundStatus.REFUNDABLE;

    //в минорных единицах
    private Long price;


}
