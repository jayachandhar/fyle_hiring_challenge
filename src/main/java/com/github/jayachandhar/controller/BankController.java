package com.github.jayachandhar.controller;

import com.github.jayachandhar.exception.ErrorResponse;
import com.github.jayachandhar.exception.GenericRunTimeException;
import com.github.jayachandhar.model.Bank;
import com.github.jayachandhar.service.BankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banks")
public class BankController {
    @Autowired
    private BankService bankService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @GetMapping(value = "/{ifscCode}", produces = {"application/json"})
    public ResponseEntity getBankByCode(@PathVariable String ifscCode) {
        try {
            logger.debug("Request received for ifsc code : " + ifscCode);
            Bank bank = bankService.getDetailsByIfscCode(ifscCode);
            logger.debug("Request successful for ifsc code : " + ifscCode);
            return new ResponseEntity<>(bank, HttpStatus.OK);
        } catch (GenericRunTimeException ex) {
            logger.error("Request failed for ifsc code : " + ifscCode + ". Reason => " + ex.getMessage());
            return new ResponseEntity<>(new ErrorResponse(ex.getErrorCode(), ex.getMessage()), HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(value = "nearbybanks", produces = {"application/json"})
    public ResponseEntity getBanksByCityBankName(@RequestParam("bankname") String bankName, @RequestParam("city") String city) {
        try {
            logger.debug("Request received for bank : " + bankName + " and city : " + city);
            List<Bank> banks = bankService.getBanksByNameCity(bankName, city);
            logger.debug("Request successful for bank : " + bankName + " and city : " + city);
            return new ResponseEntity<>(banks, HttpStatus.OK);
        } catch (GenericRunTimeException ex) {
            logger.error("Request failed for bank name : " + bankName + " and city : " + city + ". Reason => " + ex.getMessage());
            return new ResponseEntity<>(new ErrorResponse(ex.getErrorCode(), ex.getMessage()), HttpStatus.NOT_FOUND);
        }
    }
}
