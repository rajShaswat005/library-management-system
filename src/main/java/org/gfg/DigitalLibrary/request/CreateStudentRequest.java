package org.gfg.DigitalLibrary.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.gfg.DigitalLibrary.model.StudentType;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateStudentRequest {

    String studentId;
    String name;
    String email;
    String phoneNo;
    StudentType studentType;
}
