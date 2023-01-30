import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Student } from 'src/app/student/student-form/student-interface';
import { StudentService } from 'src/app/student/student.service';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  studentlist: Student[] = [];

  student!: Student;

  constructor(public studentService: StudentService) {

  }

  ngOnInit(): void {
    this.fetchStudentList();
  }

  fetchStudentList() {
    this.studentService.getStudentList().subscribe(studentList => {
      if (studentList) {
        this.studentlist = studentList;
      }
    })
  }


  deleteStudent(studentid: any) {
    this.studentService.deleteStudent(studentid).subscribe(student => {
      alert("Student deleted Successfully");
      this.fetchStudentList();
    }
    )
  }

}
