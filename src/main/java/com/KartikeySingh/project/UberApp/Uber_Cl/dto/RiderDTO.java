package com.KartikeySingh.project.UberApp.Uber_Cl.dto;

import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class RiderDTO {

    private Long id;
    private UserDTO user;
    private Double rating;
}
