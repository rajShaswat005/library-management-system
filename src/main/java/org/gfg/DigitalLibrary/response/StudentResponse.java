package org.gfg.DigitalLibrary.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentResponse extends Response{
    String studentId;
    String name;
}
