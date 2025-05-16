package com.KartikeySingh.project.UberApp.Uber_Cl.Strategies;

import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.enums.PaymentMethod;
import com.KartikeySingh.project.UberApp.Uber_Cl.Strategies.impl.CashPaymentStrategy;
import com.KartikeySingh.project.UberApp.Uber_Cl.Strategies.impl.WalletPaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.KartikeySingh.project.UberApp.Uber_Cl.Entities.enums.PaymentMethod.CASH;
import static com.KartikeySingh.project.UberApp.Uber_Cl.Entities.enums.PaymentMethod.WALLET;

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
