import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainPageComponent } from './main-page/main-page/main-page.component';
import { StudentFormComponent } from './student/student-form/student-form.component';

const routes: Routes = [
  {
    path : 'home',
    component : MainPageComponent,
  },
  {
    path : 'add-sudent',
    component : StudentFormComponent,
  },
  {
    path : 'edit-student/:id',
    component : StudentFormComponent,
    data : {action : 'edit' }
  },
  {
    path : 'login',
    loadChildren: () => import('./login-module/login-routing.module').then(m => m.LoginRoutingModule)
  },
  {
    path : '',
    loadChildren: () => import('./login-module/login-routing.module').then(m => m.LoginRoutingModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
