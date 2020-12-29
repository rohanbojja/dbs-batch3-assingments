import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './home/home.component';
import {CustomerListComponent} from './customer-list/customer-list.component';
import {CreateCustomerComponent} from './create-customer/create-customer.component';
import {DeleteCustomerComponent} from './delete-customer/delete-customer.component';
import {FindCustomerComponent} from './find-customer/find-customer.component';

const routes: Routes = [
  {
    path: 'list',
    component: CustomerListComponent
  },
  {
    path: 'create',
    component: CreateCustomerComponent
  },
  {
    path: 'delete',
    component: DeleteCustomerComponent
  },
  {
    path: 'find',
    component: FindCustomerComponent
  },
  {
    path: '**',
    component: HomeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
