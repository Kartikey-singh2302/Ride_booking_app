package com.KartikeySingh.project.UberApp.Uber_Cl.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverDTO {
    private UserDTO user;
    private Boolean available;
    private String vehicleId;
    private Long id;
}
