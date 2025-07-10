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
