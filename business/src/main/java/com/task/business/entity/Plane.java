package com.task.business.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
    private Long id;
    private String modelNumber;
    @OneToMany(mappedBy="plane")
    private Set<Seat> seats;


}
