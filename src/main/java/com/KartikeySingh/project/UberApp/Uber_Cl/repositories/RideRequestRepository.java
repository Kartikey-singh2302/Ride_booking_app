package com.KartikeySingh.project.UberApp.Uber_Cl.repositories;

import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.RideRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RideRequestRepository extends JpaRepository<RideRequest,Long> {

}
