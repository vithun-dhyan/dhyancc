import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Student } from './student-form/student-interface';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  
  constructor(private httpClient:HttpClient) { }
  student$ = new Subject();

  addStudent(student:Student)
  {
     return this.httpClient.post('/api/angular/student-management/student',student);
  }

  getStudentList()
  {
    return this.httpClient.get<any>('/api/angular/student-management/studentlist');
  }

  getStudent(id:number) :Observable<Student>
  {
     return this.httpClient.get<any>('/api/angular/student-management/student/' + id);
  }

  updateStudent(student:Student)
  {
    return this.httpClient.put<any>('/api/angular/student-management/updatestudent',student);
  }

  deleteStudent(id: number)
  {
    return this.httpClient.delete<any>('/api/angular/student-management/student/'+id);

  }
}
