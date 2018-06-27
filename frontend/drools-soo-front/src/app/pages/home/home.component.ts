import { CrudService } from './../../services/crud.service';
import { Component, OnInit } from '@angular/core';
import { RegisterModel } from '../../models/register.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  public budget: boolean;
  public userUpdate = new RegisterModel();
  public listOfBudgets;
  public civilStatusList = ['SINGLE', 'MARRIED', 'DIVORCED', 'WIDOWER'];

  constructor(private crudService: CrudService) { }

  ngOnInit() {
    this.userUpdate.CivilStatus = this.civilStatusList[0];
    this.crudService.getCreditLoan().then((serverResponse) => {
      this.listOfBudgets = serverResponse.creditLoanList;
    }).catch(((error) => {
      alert('Ocorreu um erro inesperado');
    }));
  }

  openWindowNewBudget() {
    this.budget = !this.budget;
  }

  showBudget() {
    return this.budget;
  }

  newBudget() {
    this.crudService.UpdateUser(this.userUpdate).then(() => {
      this.crudService.newCreditLoan().then(() => {
        this.crudService.getCreditLoan().then((serverResponse) => {
          this.listOfBudgets = serverResponse.creditLoanList;
          this.openWindowNewBudget();
          window.scrollTo(0, 0);
        });
      });
    }).catch(((error) => {
      alert('Ocorreu um erro inesperado');
    }));
  }

  public showListCivilStatus(e) {
    this.userUpdate.CivilStatus = e;
  }
}
