package com.KartikeySingh.project.UberApp.Uber_Cl.services;

import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.Ride;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.User;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.Wallet;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.enums.TransactionMethod;

public interface WalletService {

    Wallet AddMoneyToWallet(User user, Double amount, String transactionId, Ride ride, TransactionMethod transactionMethod);

    Wallet deductMoneyFromWallet(User user, Double amount, String transactionId, Ride ride, TransactionMethod transactionMethod);
    void withdrawAllMyMoneyFromWallet();

    Wallet findWalletById(Long WalletId);

    Wallet createNewWallet(User user);
    Wallet findByUser(User user);

}
