import { NgModule } from "@angular/core";
import { LoginPageComponent } from "./login/login.component";
import { LoginRoutingModule } from "./login-routing.module";
import { HTTP_INTERCEPTORS } from "@angular/common/http";
import { AuthInterceptor } from "./auth.service";
import { ReactiveFormsModule } from "@angular/forms";

@NgModule({
    declarations: [LoginPageComponent],
    imports: [
        LoginRoutingModule,
        ReactiveFormsModule,
    ],
    providers:[
        {
            provide: HTTP_INTERCEPTORS,
            useClass: AuthInterceptor,
            multi: true
          }
    ]
    
  })
  export class LoginModule { }
  