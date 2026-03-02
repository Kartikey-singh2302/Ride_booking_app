package com.KartikeySingh.project.UberApp.Uber_Cl.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rider implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
    @OneToOne
    @JoinColumn(name="user_id")
    private User user;
  private Double rating;
}
