import {Component, OnInit} from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
import {CustomerService} from '../services/customer.service';
import {ICustomer} from '../../entities/ICustomer';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {

  constructor(private customerService: CustomerService, private _snackBar: MatSnackBar) {
  }

  email: FormControl = new FormControl('', [Validators.required, Validators.email]);
  phone: FormControl = new FormControl('', [Validators.required, Validators.maxLength(10)]);

  ngOnInit(): void {
  }

  onSubmit(f: ICustomer): void {
    console.log(f);
    this.customerService.createCustomer(f).subscribe(
      value => {
        this._snackBar.open(`Customer with ID=${f.customerId}(${f.customerName}) created.`, 'Close');
        console.log(value);
      }
    );
  }
}
