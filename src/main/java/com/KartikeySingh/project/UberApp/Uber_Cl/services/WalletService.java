package com.KartikeySingh.project.UberApp.Uber_Cl.services;

import com.KartikeySingh.project.UberApp.Uber_Cl.entities.Ride;
import com.KartikeySingh.project.UberApp.Uber_Cl.entities.User;
import com.KartikeySingh.project.UberApp.Uber_Cl.entities.Wallet;
import com.KartikeySingh.project.UberApp.Uber_Cl.entities.enums.TransactionMethod;

public interface WalletService {

    Wallet AddMoneyToWallet(User user, Double amount, String transactionId, Ride ride, TransactionMethod transactionMethod);

    Wallet deductMoneyFromWallet(User user, Double amount, String transactionId, Ride ride, TransactionMethod transactionMethod);

    Wallet findWalletById(Long WalletId);

    Wallet createNewWallet(User user);
    Wallet findByUser(User user);

}
