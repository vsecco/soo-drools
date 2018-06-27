import { CrudService } from './../../services/crud.service';
import { RegisterModel } from './../../models/register.model';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginModel } from '../../models/login.model';
import { LoginService } from '../../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  public credentials = new LoginModel();
  public register = new RegisterModel();
  public cadastre: boolean;
  public civilStatusList = ['SINGLE', 'MARRIED', 'DIVORCED', 'WIDOWER'];

  constructor(private router: Router,
              private loginService: LoginService,
              private crudService: CrudService) { }

  ngOnInit() {
  }

  public login() {
    this.loginService.LoginUser(this.credentials).then((token) => {
      sessionStorage.setItem('tokenDrools', token.access_token);
      this.router.navigate(['home']);
    }).catch(((error) => {
      let message = 'Ocorreu um erro inesperado';
      if (error.status === 400) {
          message = 'Usuário ou senha inválidos';
      }
      alert(message);
    }));
  }

  public Cadastre() {
    return this.cadastre;
  }

  public mostrarCadastre() {
    this.cadastre = !this.cadastre;
  }

  public cadastrar() {
    this.crudService.registerUser(this.register).then(() => {
      this.credentials.Login = this.register.Cpf;
      this.credentials.Password = this.register.Password;
      this.loginService.LoginUser(this.credentials).then((token) => {
        sessionStorage.setItem('tokenDrools', token.access_token);
        this.crudService.newCreditLoan().then(() => {
          this.router.navigate(['home']);
        });
      });
    }).catch(((error) => {
      let message = 'Ocorreu um erro inesperado';
      if (error.status === 409) {
          message = 'O CPF digitado já está cadastrado.';
      }
      alert(message);
    }));
  }

  public showListCivilStatus(e) {
    this.register.CivilStatus = e;
  }
}
