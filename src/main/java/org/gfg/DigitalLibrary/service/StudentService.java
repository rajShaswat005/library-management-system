package org.gfg.DigitalLibrary.service;

import org.gfg.DigitalLibrary.model.Student;
import org.gfg.DigitalLibrary.model.StudentType;
import org.gfg.DigitalLibrary.repository.StudentDao;
import org.gfg.DigitalLibrary.request.CreateStudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    @Autowired
    StudentDao studentDao;

    public Student createStudentForLibrary(CreateStudentRequest request){
        String id = request.getStudentId();
        String type = request.getStudentType().toString();
        String name = request.getName();
        String email = request.getEmail();
        String phone = request.getPhoneNo();


        Student student = Student.builder().studentId(Integer.parseInt(id)).studentType(StudentType.valueOf(type))
                .email(email).name(name).phoneNo(phone).build();

        int result = studentDao.createStudentInDatabase(student);
        if (result>0){
            System.out.println("Data has been inserted successfully");
            return student;
        }
        return null;

    }
}
