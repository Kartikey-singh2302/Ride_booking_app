package com.KartikeySingh.project.UberApp.Uber_Cl.services;


import com.KartikeySingh.project.UberApp.Uber_Cl.dto.PointDTO;
import org.locationtech.jts.geom.Point;

public interface DistanceService {
          double calculateDistance(PointDTO src, PointDTO destination);

    double calculateDistance(Point src, Point dest);
}
