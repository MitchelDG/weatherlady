package com.mkdev.weatherlady.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity(name = "current_condition")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrentCondition {

    @Id
    @GeneratedValue
    private Long id;

    private Float temperature;

    @Column(name = "wind_direction")
    private Integer windDirection;

    @Column(name = "wind_speed")
    private Float windSpeed;

    private Float pressure;

    private String source;

    private String city;

    private String countryCode;

    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp createdAt;

    @ManyToOne(cascade = CascadeType.ALL)
    private CurrentCondition parent;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<CurrentCondition> children;

}
