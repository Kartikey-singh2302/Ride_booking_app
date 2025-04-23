package com.KartikeySingh.project.UberApp.Uber_Cl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverDTO {
    private UserDTO user;
    private Double rating;
}
