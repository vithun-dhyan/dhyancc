import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Subscription } from 'rxjs';
import { Student } from 'src/app/student/student-form/student-interface';
import { StudentService } from 'src/app/student/student.service';
import { LoginPageService } from '../login.service';

@Component({
  selector: 'login-page',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginPageComponent {
    
    studentForm: FormGroup;
    constructor() {
        this.studentForm = new FormGroup({
           
          })
    }

    dologin()
    {
        console.log(this.studentForm.value["name"] + this.studentForm.value["password"])
        // this.loginservice.login(this.studentForm.value["name"], this.studentForm.value["password"]);
    }
   
}
