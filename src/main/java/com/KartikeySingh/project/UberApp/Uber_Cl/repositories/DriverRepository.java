package com.KartikeySingh.project.UberApp.Uber_Cl.repositories;

import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.Driver;
import com.KartikeySingh.project.UberApp.Uber_Cl.dto.PointDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
//ST_Distance(point1, point2)
//ST_DWithin(point1 ,10000)---> this is distance within
@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {

    @Query("SELECT d.*, ST_DISTANCE(d.current_location, :pickupLocation) AS distance " +
            "FROM drivers AS d " +
            "where available = true AND ST_DWithin(d.current_location, :pickupLocation, 10000) " +
            "ORDER BY distance " +
            "LIMIT 10"
    )

    List<Driver> findTenNearestDrivers(PointDTO pickupLocation);


    @Query(value="SELECT d.*, " +
            "FROM Drivers d " +
            "WHERE d.available = true AND ST_DWithin(d.current_location, pickupLocation, 15000 " +
            "ORDER BY d.rating  DESC" +
            "LIMIT 10 ",nativeQuery =true)
    List<Driver> findTenNearbyTopRatedDrivers(PointDTO pickupLocation);
}
