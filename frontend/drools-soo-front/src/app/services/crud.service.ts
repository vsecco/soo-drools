import { RegisterModel } from './../models/register.model';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CrudService {

  private updateRegisterUrl = 'http://localhost:8080/user/update';
  private getCreditLoanUrl = 'http://localhost:8080/audit/list';
  private newCreditLoanUrl = 'http://localhost:8080/creditloan/new';
  private registerUserUrl = 'http://localhost:8080/public/user/new';

  constructor(private http: HttpClient) { }

  public UpdateUser(registerModel: RegisterModel): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      const body = {
        civilStatus: registerModel.CivilStatus,
        amountOfProperty: registerModel.Amount
      };

      let headers = new HttpHeaders();
      headers = headers.set('Content-Type', 'application/json');
      headers = headers.set('Authorization', 'Bearer ' + sessionStorage.getItem('tokenDrools'));

      this.http.put<any>(this.updateRegisterUrl, body, { headers }).subscribe(() => {
        resolve();
      }, ((error) => {
        reject(error);
      }));
    });
  }

  public getCreditLoan(): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      let headers = new HttpHeaders();
      headers = headers.set('Content-Type', 'application/json');
      headers = headers.set('Authorization', 'Bearer ' + sessionStorage.getItem('tokenDrools'));

      this.http.get<any>(this.getCreditLoanUrl, { headers }).subscribe((serverResponse) => {
        resolve(serverResponse);
      }, ((error) => {
        reject(error);
      }));
    });
  }

  public newCreditLoan(): Promise<any> {
    return new Promise<any>((resolve, reject) => {

      let headers = new HttpHeaders();
      headers = headers.set('Authorization', 'Bearer ' + sessionStorage.getItem('tokenDrools'));

      this.http.post<any>(this.newCreditLoanUrl, { headers }).subscribe(() => {
        resolve();
      }, ((error) => {
        reject(error);
      }));
    });
  }

  public registerUser(registerModel: RegisterModel): Promise<any> {
    return new Promise<any>((resolve, reject) => {

      let headers = new HttpHeaders();
      headers = headers.set('Content-Type', 'application/json');

      const body = {
        name: registerModel.Name,
        cpf: registerModel.Cpf,
        birthdate: registerModel.Bithday,
        civilStatus: registerModel.CivilStatus,
        amountOfProperty: registerModel.Amount,
        password: registerModel.Password,
      };

      this.http.post<any>(this.registerUserUrl, body, { headers }).subscribe(() => {
        resolve();
      }, ((error) => {
        reject(error);
      }));
    });
  }
}

