import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { LoginModel } from '../models/login.model';

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

      const headers = new HttpHeaders();
      headers.set('Content-Type', 'application/json');

      this.http.post<any>(this.loginUrl, body, { headers }).subscribe((serverResponse) => {
        resolve(serverResponse);
      }, ((error) => {
        reject(error);
      }));
    });
  }
}

