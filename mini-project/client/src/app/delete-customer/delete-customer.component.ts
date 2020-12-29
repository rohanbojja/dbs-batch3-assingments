import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../services/customer.service';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-delete-customer',
  templateUrl: './delete-customer.component.html',
  styleUrls: ['./delete-customer.component.css']
})
export class DeleteCustomerComponent implements OnInit {

  constructor(private customerService: CustomerService, private _snackBar: MatSnackBar) {
  }

  ngOnInit(): void {
  }

  delete(f: any): void {
    this.customerService.deleteCustomer(f.customerId).subscribe(
      value => {
        console.log(value);
        this._snackBar.open(`Customer with ID=${f.customerId} deleted.`, 'Close');
      }, e => {
        console.log(e.message);
        this._snackBar.open(`Could not delete customer. [${e.message}]`, 'Close');
      }
    );
  }

}
