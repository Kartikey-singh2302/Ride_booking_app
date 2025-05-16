package com.KartikeySingh.project.UberApp.Uber_Cl.Strategies.impl;


import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.Driver;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.Payment;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.Rider;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.enums.PaymentStatus;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.enums.TransactionMethod;
import com.KartikeySingh.project.UberApp.Uber_Cl.Strategies.PaymentStrategy;
import com.KartikeySingh.project.UberApp.Uber_Cl.repositories.PaymentRepository;
import com.KartikeySingh.project.UberApp.Uber_Cl.services.PaymentService;
import com.KartikeySingh.project.UberApp.Uber_Cl.services.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//rider has 232rs ,driver has 500
//ride cost rs=100 ,commission is 30rs
//rider->232-100=132
//driver -> 500+(100-30)=570

@Service
@RequiredArgsConstructor
public class WalletPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;
    @Override
    public void processPayment(Payment payment) {
        Driver driver =payment.getRide().getDriver();
        Rider rider = payment.getRide().getRider();

        walletService.deductMoneyFromWallet(rider.getUser(),payment.getAmount(),null,
                payment.getRide(), TransactionMethod.RIDE);

        double driversCut = payment.getAmount() * (1-PLATFORM_COMMISSION);

        walletService.AddMoneyToWallet(driver.getUser(),driversCut,null,payment.getRide(),TransactionMethod.RIDE);

        payment.setPaymentstatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);

    }
}
