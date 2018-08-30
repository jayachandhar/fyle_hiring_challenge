package com.github.jayachandhar.service;

import com.github.jayachandhar.exception.GenericRunTimeException;
import com.github.jayachandhar.model.Bank;
import com.github.jayachandhar.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class BankService {
    @Autowired
    private BankRepository bankRepository;

    public Bank getDetailsByIfscCode(String ifscCode) {
        if (StringUtils.isEmpty(ifscCode) || ifscCode.length() != 11)
            throw new GenericRunTimeException("4005", "Invalid IFSC code");
        Bank bank = bankRepository.findOne(ifscCode);
        if (bank != null)
            return bank;
        else
            throw new GenericRunTimeException("4004", "No Record available");
    }

    public List<Bank> getBanksByNameCity(String bankName, String city) {
        if (StringUtils.isEmpty(city))
            throw new GenericRunTimeException("4005", "Invalid City name");
        if (StringUtils.isEmpty(bankName))
            throw new GenericRunTimeException("4005", "Invalid Bank name");

        List<Bank> banks = bankRepository.getBanksByBankNameAndCity(bankName.toUpperCase(), city.toUpperCase());
        if (banks != null && banks.size() != 0)
            return banks;
        else
            throw new GenericRunTimeException("4004", "No Record available");
    }
}
