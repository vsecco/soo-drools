import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  public credentials = {
    login: '',
    password: '',
  };
  public cadastre: boolean;

  constructor(private router: Router) { }

  ngOnInit() {
  }

  public login() {
    this.router.navigate(['home']);
  }

  public Cadastre() {
    return this.cadastre;
  }

  public mostrarCadastre() {
    this.cadastre = !this.cadastre;
  }

}
