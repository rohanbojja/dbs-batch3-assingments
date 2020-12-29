import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../services/customer.service';
import {ICustomer} from '../../entities/ICustomer';
import {BehaviorSubject, Observable} from 'rxjs';

@Component({
  selector: 'app-find-customer',
  templateUrl: './find-customer.component.html',
  styleUrls: ['./find-customer.component.css']
})
export class FindCustomerComponent implements OnInit {

  customer$!: BehaviorSubject<ICustomer | null>;

  constructor(private customerService: CustomerService) {
  }

  ngOnInit(): void {
    this.customer$ = new BehaviorSubject<ICustomer | null>(null);
  }

  filterById(f: any): void {
    console.log(f.customerId);
    // handle error here
    this.customerService.findCustomer(f.customerId).subscribe(
      c => {
        console.log(c);
        this.customer$.next(c);
      }
    );
  }
}
