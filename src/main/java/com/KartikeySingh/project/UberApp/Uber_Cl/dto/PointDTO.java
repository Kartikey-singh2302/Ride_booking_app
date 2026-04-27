package com.KartikeySingh.project.UberApp.Uber_Cl.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
//lat long k liye h
public class PointDTO {
    private double[] coordinates;
    private String type ="Point";

    public PointDTO(double[] coordinates)
    {
        this.coordinates=coordinates;
    }

    public String getX() {
        return null;
    }


    public String getY() {
    return null;
    }





}
