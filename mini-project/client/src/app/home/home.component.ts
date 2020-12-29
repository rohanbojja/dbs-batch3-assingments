import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../services/customer.service';
import {BehaviorSubject, Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {ICustomer} from '../../entities/ICustomer';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  constructor(private customerService: CustomerService) {
  }

  customerList$!: Observable<ICustomer[]>;
  customer$!: BehaviorSubject<ICustomer | null>;
  displayedColumns!: string[];
  displayedColumnsHeaders!: string[];

  ngOnInit(): void {
    this.customer$ = new BehaviorSubject<ICustomer | null>(null);
    this.displayedColumns = ['customerId', 'customerName', 'address', 'email', 'mobileNo', 'favorite'];
    this.displayedColumnsHeaders = ['ID', 'Name'];
    this.customerList$ = this.customerService.getCustomerList().pipe(map(
      value => {
        return value.filter(
          value1 => {
            return value1.favorite;
          }
        );
      }
    ));
    this.customerList$.subscribe(
      value => {
        console.log(value);
      }
    );
  }

  toggleFavorite(customerId: string): void {
    this.customerService.toggleFavorite(customerId).subscribe(
      () => {
        this.customerList$ = this.customerService.getCustomerList().pipe(map(
          value => {
            return value.filter(
              value1 => {
                return value1.favorite;
              }
            );
          }
        ));
      }
    );
  }

  selectCustomer(c: ICustomer): void{
    console.log(c);
    this.customer$.next(c);
  }

}
