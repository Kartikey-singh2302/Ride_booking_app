package com.KartikeySingh.project.UberApp.Uber_Cl.services;

import com.KartikeySingh.project.UberApp.Uber_Cl.entities.Payment;
import com.KartikeySingh.project.UberApp.Uber_Cl.entities.Ride;
import com.KartikeySingh.project.UberApp.Uber_Cl.entities.enums.PaymentStatus;

public interface PaymentService {

    void ProcessPayment(Ride ride);

    Payment CreateNewPayment(Ride ride);
    void updatePaymentStatus(Payment payment, PaymentStatus status);
}
