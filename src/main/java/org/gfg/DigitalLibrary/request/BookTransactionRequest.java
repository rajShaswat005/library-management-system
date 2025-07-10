package org.gfg.DigitalLibrary.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookTransactionRequest {

    int studentId;
    int bookId;
    String amount;
    String requestType;
}
