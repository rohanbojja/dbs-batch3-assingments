import {Component, Input, OnInit} from '@angular/core';
import {ICustomer} from '../../entities/ICustomer';
import {BehaviorSubject, Observable} from 'rxjs';
import {CustomerService} from '../services/customer.service';

@Component({
  selector: 'app-customer-detail',
  templateUrl: './customer-detail.component.html',
  styleUrls: ['./customer-detail.component.css']
})
export class CustomerDetailComponent implements OnInit {

  constructor(public customerService: CustomerService) {
  }

  @Input()
  customer!: ICustomer;

  ngOnInit(): void {
  }

  ediCustomer(): void{
    this.customerService.editing.next(!this.customerService.editing.getValue());
  }
}
