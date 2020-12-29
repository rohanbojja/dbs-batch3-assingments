import {Component, Input, OnInit} from '@angular/core';
import {ICustomer} from '../../entities/ICustomer';
import {BehaviorSubject, Observable} from 'rxjs';

@Component({
  selector: 'app-customer-detail',
  templateUrl: './customer-detail.component.html',
  styleUrls: ['./customer-detail.component.css']
})
export class CustomerDetailComponent implements OnInit {

  constructor() { }
  @Input()
  customer!: ICustomer;
  ngOnInit(): void {
  }
}
