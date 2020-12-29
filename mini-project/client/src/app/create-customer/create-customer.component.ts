import {Component, OnInit} from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
import {CustomerService} from '../services/customer.service';
import {ICustomer} from '../../entities/ICustomer';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {

  constructor(private customerService: CustomerService) {
  }

  email: FormControl = new FormControl('', [Validators.required, Validators.email]);
  phone: FormControl = new FormControl('', [Validators.required, Validators.maxLength(10)]);

  ngOnInit(): void {
  }

  onSubmit(f: ICustomer): void {
    console.log(f);
    this.customerService.createCustomer(f).subscribe(
      value => {
        console.log(value);
      }
    );
  }

  getErrorMessage(): string {
    if (this.email.hasError('required')) {
      return 'You must enter a value';
    }

    return this.email.hasError('email') ? 'Not a valid email' : '';
  }
}
