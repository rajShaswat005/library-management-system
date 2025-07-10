package org.gfg.DigitalLibrary.controller;

import org.gfg.DigitalLibrary.model.Student;
import org.gfg.DigitalLibrary.request.CreateStudentRequest;
import org.gfg.DigitalLibrary.response.StudentResponse;
import org.gfg.DigitalLibrary.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {


    @Autowired
    StudentService studentService;

    @PostMapping
    @RequestMapping("/create/student")
    public ResponseEntity<StudentResponse> createStudent(@RequestBody CreateStudentRequest createStudentRequest){
        StudentResponse studentResponse = new StudentResponse();

        Student student =  studentService.createStudentForLibrary(createStudentRequest);

        if (student==null){
            studentResponse.setErrCode("001");
            studentResponse.setMessage("Data Not Created");
            return new ResponseEntity<>(studentResponse, HttpStatus.BAD_REQUEST);
        }

        studentResponse.setErrCode("00");
        studentResponse.setMessage("Student Has been created");
        studentResponse.setStudentId(Integer.toString(student.getStudentId()));
        studentResponse.setName(student.getName());
        return new ResponseEntity<>(studentResponse,HttpStatus.CREATED);



    }

}
