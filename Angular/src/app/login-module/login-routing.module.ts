import { RouterModule, Routes } from "@angular/router";
import { LoginPageComponent } from "./login/login.component";
import { NgModule } from "@angular/core";

const routes: Routes = [
    {
      path : '',
      component : LoginPageComponent,
    },
    
  ];
  
  @NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
  })
  export class LoginRoutingModule { }