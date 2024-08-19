import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

export class LoginPageService {
    constructor(private httpClient:HttpClient) { }


    
  login(username:string, pwd: string)
  {
    // return this.httpClient.post('/api/angular/student-management/student',);
  }
}