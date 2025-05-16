package com.KartikeySingh.project.UberApp.Uber_Cl.services.impl;
import com.KartikeySingh.project.UberApp.Uber_Cl.services.DistanceService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.awt.*;
import java.util.List;

@Service
public class DistanceServiceOSRMImpl implements DistanceService {

        private static final String OSRM_API_BASE_URL = "https://router.project-osrm.org/route/v1/driving/";

        public double calculateDistance(Point src, Point dest) {
           try{
               String uri = src.getX() + "," + src.getY() + ";" + dest.getX() + "," + dest.getY();
               OSRMResponseDTO responseDto= RestClient.builder()
                       .baseUrl(OSRM_API_BASE_URL)
                         .build()
                       .get()
                       .uri(uri)
                       .retrieve()
                       .body(OSRMResponseDTO.class);

               return responseDto.getRoutes().get(0).getDistance()/1000.0;
           }
           catch(Exception e)
           {
               throw new RuntimeException("Error getting data from OSRM"+e.getMessage());
           }
        }

}

@Data
class OSRMResponseDTO {
    private List<OSRMRoute> routes; // Ensure proper mapping
}

@Data
class OSRMRoute {
    private double distance; // Ensure JSON field matches
}



