import {Component, Input, OnInit} from '@angular/core';
import {CustomerService} from '../services/customer.service';
import {MatSnackBar} from '@angular/material/snack-bar';
import {FormControl, Validators} from '@angular/forms';
import {ICustomer} from '../../entities/ICustomer';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {

  constructor(private customerService: CustomerService, private _snackBar: MatSnackBar) {
  }

  email: FormControl = new FormControl('', [Validators.required, Validators.email]);
  phone: FormControl = new FormControl('', [Validators.required, Validators.maxLength(10)]);

  @Input()
  customer!: ICustomer;

  ngOnInit(): void {
  }

  onSubmit(f: ICustomer): void {
    console.log(f);
    this.customerService.editCustomer(f).subscribe(
      value => {
        this._snackBar.open(`Customer with ID=${f.customerId}(${f.customerName}) edited.`, 'Close');
        console.log(value);
      }, e => {
        this._snackBar.open(`Customer with ID=${f.customerId} doesn't exist. [${e.message}]`, 'Close');
      }
    );
    this.customerService.editing.next(false);
  }

}
