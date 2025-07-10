package org.gfg.DigitalLibrary.controller;

import org.gfg.DigitalLibrary.request.BookTransactionRequest;
import org.gfg.DigitalLibrary.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;


    @RequestMapping("/book/issue")
    @PostMapping
    public boolean bookTransaction(@RequestBody BookTransactionRequest bookTransactionRequest){
        return transactionService.issueBook(bookTransactionRequest);
    }
}
