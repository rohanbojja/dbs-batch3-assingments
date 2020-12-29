import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../services/customer.service';

@Component({
  selector: 'app-delete-customer',
  templateUrl: './delete-customer.component.html',
  styleUrls: ['./delete-customer.component.css']
})
export class DeleteCustomerComponent implements OnInit {

  constructor(private customerService: CustomerService) {
  }

  ngOnInit(): void {
  }

  delete(f: any): void {
    this.customerService.deleteCustomer(f.customerId);
  }

}
