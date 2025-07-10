package org.gfg.DigitalLibrary.service;

import org.gfg.DigitalLibrary.repository.TransactionDAO;
import org.gfg.DigitalLibrary.request.BookTransactionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    TransactionDAO transactionDAO;

    public boolean issueBook(BookTransactionRequest bookTransactionRequest){
        int row= transactionDAO.issueBookToStudent(bookTransactionRequest);
        if (row>0){
            return true;
        }
        return false;
    }
}
