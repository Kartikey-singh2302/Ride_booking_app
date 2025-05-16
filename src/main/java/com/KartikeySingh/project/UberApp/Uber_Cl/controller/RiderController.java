package com.KartikeySingh.project.UberApp.Uber_Cl.controller;

import com.KartikeySingh.project.UberApp.Uber_Cl.dto.*;
import com.KartikeySingh.project.UberApp.Uber_Cl.services.RiderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rider")
@RequiredArgsConstructor
@Secured("ROLE_RIDER")
public class RiderController {

    private final RiderService  riderService;


    @PostMapping("/requestRide")
    public ResponseEntity<RideRequestDTO> requestRide(@RequestBody RideRequestDTO riderequestDTO)
    {
       return ResponseEntity.ok( riderService.requestRide(riderequestDTO));
    }

    @PostMapping("/cancelRide/{rideId}")
    public ResponseEntity<RideDTO> cancelRide(@PathVariable Long RideId)
    {
        return ResponseEntity.ok(riderService.cancelRide(RideId));
    }

    @PostMapping("/rateDriver")
    public ResponseEntity<DriverDTO> rateDriver(@RequestBody RatingDTO ratingDTO)
    {
         return ResponseEntity.ok(riderService.rateDriver(ratingDTO.getRideId(),ratingDTO.getRating()));
    }

    @GetMapping("/getMyProfile")
    public ResponseEntity<RiderDTO> getMyProfile()
    {
        return ResponseEntity.ok(riderService.getMyProfile());
    }

    @GetMapping("/getMyRides")
        public ResponseEntity<Page<RideDTO>> getAllMyRides(@RequestParam(defaultValue = "0") Integer pageOffSet,
                                                           @RequestParam(defaultValue = "10", required = false)
                                                           Integer pageSize){
        PageRequest pageRequest = PageRequest.of(pageOffSet, pageSize);
        return ResponseEntity.ok(riderService.getAllMyRides(pageRequest));

        //****👆 ye iska explaination h
        // ye line ek successful HTTP response(200ok) return kregi jisme  body data me paginated data hoga
        // jo riderService.getAllMyRides(pageRequest) se aya hoga
    }

    @PostMapping("/rateDriver/{rideId}/{rating}")
    public ResponseEntity<DriverDTO> rateDriver(@PathVariable Long rideId, @PathVariable Integer rating)
    {
        return ResponseEntity.ok(riderService.rateDriver(rideId,rating));
    }





}
