package com.KartikeySingh.project.UberApp.Uber_Cl.repositories;

import com.KartikeySingh.project.UberApp.Uber_Cl.entities.Rider;
import com.KartikeySingh.project.UberApp.Uber_Cl.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RiderRepository extends JpaRepository<Rider,Long> {

    Optional<Rider> findByUser(User user);
}
