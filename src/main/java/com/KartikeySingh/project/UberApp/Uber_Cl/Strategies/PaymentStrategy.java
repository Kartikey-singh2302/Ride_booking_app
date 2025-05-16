package com.KartikeySingh.project.UberApp.Uber_Cl.Strategies;

import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.Payment;

public interface PaymentStrategy {

    Double PLATFORM_COMMISSION =0.3;

    void processPayment(Payment payment);
}
