package com.KartikeySingh.project.UberApp.Uber_Cl.services;

import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.Payment;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.Ride;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.enums.PaymentStatus;

public interface PaymentService {

    void ProcessPayment(Ride ride);

    Payment CreateNewPayment(Ride ride);
    void updatePaymentStatus(Payment payment, PaymentStatus status);
}
