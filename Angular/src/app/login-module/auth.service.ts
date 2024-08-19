import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { Observable } from "rxjs";
import { tap } from "rxjs/operators";

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private router: Router) { }
  // intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
  //   return next.handle(req).pipe(tap(() => { },
  //     (err: any) => {
  //       if (err instanceof HttpErrorResponse) {
  //         if (err.status !== 401) {
  //           return;
  //         }
  //         let currentUrl = this.router.routerState.snapshot.url.split("?")[0];
  //         if (currentUrl != "/login") {
  //           let queryParam:any = {};
  //           debugger;  
  //           queryParam['referer'] = this.router.routerState.snapshot.url;
  //           this.router.navigate(["/login"], { queryParams: queryParam });
  //         }
  //       }
  //     }));
  // }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    // add header with basic auth credentials if user is logged in and request is to the api url
    request = request.clone({
        setHeaders: { 
            Authorization: `Basic ` +  btoa('user1:user1')
        }
    });
   
    return next.handle(request);
}
}