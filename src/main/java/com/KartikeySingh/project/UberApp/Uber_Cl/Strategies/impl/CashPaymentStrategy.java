package com.KartikeySingh.project.UberApp.Uber_Cl.Strategies.impl;

import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.Driver;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.Payment;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.Wallet;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.enums.PaymentStatus;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.enums.TransactionMethod;
import com.KartikeySingh.project.UberApp.Uber_Cl.Strategies.PaymentStrategy;
import com.KartikeySingh.project.UberApp.Uber_Cl.repositories.PaymentRepository;
import com.KartikeySingh.project.UberApp.Uber_Cl.services.PaymentService;
import com.KartikeySingh.project.UberApp.Uber_Cl.services.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//rider ->100
//driver->70 deduct 30rs from the driver's wallet
@Service
@RequiredArgsConstructor
public class CashPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
private final PaymentRepository paymentRepository;
    @Override
    public void processPayment(Payment payment) {
        Driver driver =payment.getRide().getDriver();

        Wallet driverWallet=walletService.findByUser(driver.getUser());
        double platformCommission = payment.getAmount()*PLATFORM_COMMISSION;

        walletService.deductMoneyFromWallet(driver.getUser(),platformCommission,null
                ,payment.getRide(), TransactionMethod.RIDE);

        payment.setPaymentstatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);
    }
}


//10 rating count =4.0
//new rating 4.6
//new rating 4.6/11=4.05