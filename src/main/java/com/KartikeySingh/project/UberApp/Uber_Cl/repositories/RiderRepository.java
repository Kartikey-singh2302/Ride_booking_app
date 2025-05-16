package com.KartikeySingh.project.UberApp.Uber_Cl.repositories;

import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.Rider;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RiderRepository extends JpaRepository<Rider,Long> {

    Optional<Rider> findByUser(User user);
}
