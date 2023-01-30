import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Student } from 'src/app/student-form/student-form/student-interface';
import { StudentService } from 'src/app/student-form/student.service';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  studentlist: Student[] = [];

  student!: Student;

  selectedStudents: Map<any, Student> = new Map();

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

  onCheckboxChange(event: any, student: Student) {
    if (event.target.checked)
      this.selectedStudents.set(student.id, student);
    else
      this.selectedStudents.delete(student.id);
  }

}
