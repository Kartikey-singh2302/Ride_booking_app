package com.KartikeySingh.project.UberApp.Uber_Cl.strategies;

import com.KartikeySingh.project.UberApp.Uber_Cl.entities.enums.PaymentMethod;
import com.KartikeySingh.project.UberApp.Uber_Cl.strategies.impl.CashPaymentStrategy;
import com.KartikeySingh.project.UberApp.Uber_Cl.strategies.impl.WalletPaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentStrategyManager {

    private final WalletPaymentStrategy walletPaymentStrategy;
    private final CashPaymentStrategy cashPaymentStrategy;

    public PaymentStrategy paymentStrategy(PaymentMethod paymentMethod) {
        return switch (paymentMethod) {
            case WALLET -> walletPaymentStrategy;
            case CASH -> cashPaymentStrategy;
        };

    }
}
