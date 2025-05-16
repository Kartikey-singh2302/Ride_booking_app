package com.KartikeySingh.project.UberApp.Uber_Cl.services.impl;

import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.Ride;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.User;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.Wallet;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.WalletTransaction;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.enums.TransactionMethod;
import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.enums.TransactionType;
import com.KartikeySingh.project.UberApp.Uber_Cl.dto.RideDTO;
import com.KartikeySingh.project.UberApp.Uber_Cl.dto.WalletDTO;
import com.KartikeySingh.project.UberApp.Uber_Cl.dto.WalletTransactionDTO;
import com.KartikeySingh.project.UberApp.Uber_Cl.exceptions.ResourceNotFoundException;
import com.KartikeySingh.project.UberApp.Uber_Cl.repositories.WalletRepository;
import com.KartikeySingh.project.UberApp.Uber_Cl.services.WalletService;
import com.KartikeySingh.project.UberApp.Uber_Cl.services.WalletTransactionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final ModelMapper modelMapper;
    private final WalletRepository walletRepository;
    private final WalletTransactionService walletTransactionService;

    @Override
    @Transactional
    public Wallet AddMoneyToWallet(User user, Double amount, String transactionId, Ride ride, TransactionMethod transactionMethod) {
        Wallet wallet = findByUser(user);
        wallet.setBalance(wallet.getBalance()+amount);
        WalletTransaction walletTransaction = WalletTransaction.builder()
                .transactionId(transactionId)
                .ride(ride)
                .wallet(wallet)
                .transactiontype(TransactionType.CREDIT)
                .transactionMethod(transactionMethod)
                .amount(amount)
                .build();

        walletTransactionService.CreateNewWalletTransaction(walletTransaction);
        return walletRepository.save(wallet);
    }


    @Override
    @Transactional
    public Wallet deductMoneyFromWallet(User user, Double amount, String transactionId, Ride ride, TransactionMethod transactionMethod) {
        Wallet wallet = findByUser(user);
        wallet.setBalance(wallet.getBalance()-amount);

        WalletTransaction walletTransaction = WalletTransaction.builder()
                .transactionId(transactionId)
                .ride(ride)
                .wallet(wallet)
                .transactiontype(TransactionType.DEBIT)
                .transactionMethod(transactionMethod)
                .amount(amount)
                .build();

        //walletTransactionService.CreateNewWalletTransaction(walletTransaction);

        wallet.getTransaction().add(walletTransaction);
        return walletRepository.save(wallet);
    }


    @Override
    public void withdrawAllMyMoneyFromWallet() {

    }

    @Override
    public Wallet findWalletById(Long walletId) {
        return walletRepository.findById(walletId)
                .orElseThrow(()->new ResourceNotFoundException("wallet not found with this id: "+walletId));
    }

    @Override
    public Wallet createNewWallet(User user) {
        Wallet wallet = new Wallet();
        wallet.setUser(user);
        return walletRepository.save(wallet);
    }

    @Override
    public Wallet findByUser(User user) {
        return walletRepository.findByUser(user)
                .orElseThrow(()->new ResourceNotFoundException("Wallet not found for user with id:"+user.getId()));

    }
}
