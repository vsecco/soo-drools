import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { LoginModel } from '../models/login.model';
import { SELECT_VALUE_ACCESSOR } from '@angular/forms/src/directives/select_control_value_accessor';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private loginUrl = 'http://localhost:8080/oauth/token';
  constructor(private http: HttpClient) { }

  public LoginUser(loginModel: LoginModel): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      const body = {
        username: loginModel.Login,
        password: loginModel.Password,
        grant_type: 'password',
      };

      let headers = new HttpHeaders();
      headers = headers.set('Content-Type', 'application/x-www-form-urlencoded');
      headers = headers.set('Authorization', 'Basic Y3JlZGl0LWxvYW46c2VjcmV0');

      const searchParams = Object.keys(body).map((key) => {
        return encodeURIComponent(key) + '=' + encodeURIComponent(body[key]);
      }).join('&');

      this.http.post<any>(this.loginUrl, searchParams, { headers }).subscribe((serverResponse) => {
        resolve(serverResponse);
      }, ((error) => {
        reject(error);
      }));
    });
  }
}

