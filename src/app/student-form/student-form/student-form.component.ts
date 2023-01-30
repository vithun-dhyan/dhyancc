import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { StudentService } from '../student.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-student-form',
  templateUrl: './student-form.component.html',
  styleUrls: ['./student-form.component.css']
})
export class StudentFormComponent implements OnInit {
  studentForm: FormGroup;
  isEdit: Boolean = false;
  title :string = "STUDENT FORM";
  id!:number;

  action: string = '';
  constructor(public studentService: StudentService, private location: Location, private activatedRoute: ActivatedRoute, private route: Router) {
    this.studentForm = new FormGroup({
      name: new FormControl('', Validators.required),
      studentid: new FormControl('', Validators.required),
      age: new FormControl('', Validators.required),
      address: new FormControl('', Validators.required),
      gender: new FormControl('', Validators.required),
    })
  }
  
  ngOnInit(): void {
    
    this.action = this.activatedRoute.snapshot.data['action'];
    if (this.action == 'edit') {
      this.title = "EDIT STUDENT FORM";
      this.id = Number(this.activatedRoute.snapshot.paramMap.get('id'));
      this.editStudent();
    }

  }

  editStudent() {
    this.studentService.getStudent(this.id).subscribe(student => {

      if (student) {
        this.studentForm.setValue({
          name: student.name,
          age: student.age,
          studentid: student.studentid,
          address: student.address,
          gender: student.gender

        })
      }
    }
    )
  }

  submit()
  {
    if(this.action != 'edit')
    {
      this.addStudent();
    }
    else{
      this.updateStudent();
    }
  }

  addStudent() {
    this.studentService.addStudent(this.studentForm.value).subscribe(data => {
      if (data) {
        alert("Student data added succesfully");
        this.resetForm();
        this.location.back();
      }
    })
  }

  updateStudent()
  {
    this.studentForm.value['id'] = this.id
    this.studentService.updateStudent(this.studentForm.value).subscribe(data => {
      if (data) {
        alert("Student data updated succesfully");
        this.resetForm();
        this.location.back();
      }
    })
  }

  resetForm() {
    this.studentForm.reset();
  }

}
