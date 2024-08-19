import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Student } from './student-form/student-interface';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  
  constructor(private httpClient:HttpClient) { }

  addStudent(student:Student)
  {
     return this.httpClient.post('/api/angular/student-management/students',student);
  }

  getStudentList()
  {
    return this.httpClient.get<any>('/api/angular/student-management/students');
  }

  getStudent(id:number) : Observable<Student>
  {
     return this.httpClient.get<any>('/api/angular/student-management/students/' + id);
  }

  updateStudent(student:Student)
  {
    return this.httpClient.put<any>('/api/angular/student-management/students/' + student.id ,student);
  }

  deleteStudent(id: number)
  {
    return this.httpClient.delete<any>('/api/angular/student-management/students/'+id);

  }
}
