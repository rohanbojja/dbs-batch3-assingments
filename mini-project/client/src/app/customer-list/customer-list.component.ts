import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../services/customer.service';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {ICustomer} from '../../entities/ICustomer';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  constructor(private customerService: CustomerService) {
  }

  customerList$!: Observable<ICustomer[]>;
  displayedColumns!: string[];
  displayedColumnsHeaders!: string[];

  ngOnInit(): void {
    this.displayedColumns = ['customerId', 'customerName', 'address', 'email', 'mobileNo', 'favorite'];
    this.displayedColumnsHeaders = ['ID', 'Name'];
    this.customerList$ = this.customerService.getCustomerList();
    this.customerList$.subscribe(
      value => {
        console.log(value);
      }
    );
  }

  toggleFavorite(customerId: string): void {
    this.customerService.toggleFavorite(customerId).subscribe(
      () => {
        this.customerList$ = this.customerService.getCustomerList();
      }
    );
  }

  filterByName(f: any): void {
    this.customerList$ = this.customerService.getCustomerList().pipe(map(
      value => {
        return value.filter(
          value1 => {
            console.log(value1.customerName, f.customerName);
            if (value1.customerName != null) {
              return value1.customerName.toLocaleLowerCase().includes(f.customerName.toLocaleLowerCase());
            }
            return false;
          }
        );
      }
    ));
  }

}
