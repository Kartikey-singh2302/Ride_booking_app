package com.KartikeySingh.project.UberApp.Uber_Cl.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
    @OneToOne
    @JoinColumn(name="user_id")
    private User user;
  private Double rating;
}
