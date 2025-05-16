package com.KartikeySingh.project.UberApp.Uber_Cl.services.impl;

import com.KartikeySingh.project.UberApp.Uber_Cl.Entities.WalletTransaction;
import com.KartikeySingh.project.UberApp.Uber_Cl.dto.WalletTransactionDTO;
import com.KartikeySingh.project.UberApp.Uber_Cl.repositories.WalletTransactionRepository;
import com.KartikeySingh.project.UberApp.Uber_Cl.services.WalletTransactionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletTransactionServiceImpl implements WalletTransactionService {

    private final WalletTransactionRepository walletTransactionRepository;
    private final ModelMapper modelMapper;
    @Override
    public void CreateNewWalletTransaction(WalletTransaction walletTransaction) {
        // *****imp**padho-*

        // walletTransactionDTO ek "request DTO" hai jo client se data lekar aaya hai,
        // jisko hume database me store karne ke liye WalletTransaction type me convert karna padta hai,
        // jo ek entity class hai.
        // Aur jo walletTransaction(left side wala) object banega, wahi entity ka object
        // hai jo database me column banega.
        walletTransactionRepository.save(walletTransaction);

    }
}
