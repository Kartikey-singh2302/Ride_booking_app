package com.KartikeySingh.project.UberApp.Uber_Cl.strategies.impl;

import com.KartikeySingh.project.UberApp.Uber_Cl.entities.Driver;
import com.KartikeySingh.project.UberApp.Uber_Cl.entities.Payment;
import com.KartikeySingh.project.UberApp.Uber_Cl.entities.Wallet;
import com.KartikeySingh.project.UberApp.Uber_Cl.entities.enums.PaymentStatus;
import com.KartikeySingh.project.UberApp.Uber_Cl.entities.enums.TransactionMethod;
import com.KartikeySingh.project.UberApp.Uber_Cl.strategies.PaymentStrategy;
import com.KartikeySingh.project.UberApp.Uber_Cl.repositories.PaymentRepository;
import com.KartikeySingh.project.UberApp.Uber_Cl.services.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
<<<<<<< HEAD
//10 rating count =4.0
//new rating 4.6
//new rating 4.6/11=4.05
=======
>>>>>>> origin/master
