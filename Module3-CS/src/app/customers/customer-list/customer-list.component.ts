import { Component, OnInit } from '@angular/core';
import { ICustomer } from '../models/customer';
import { CustomerService } from '../services/customer.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.scss']
})
export class CustomerListComponent implements OnInit {

  customerList$: Observable<ICustomer[]>;
  constructor(
    private customerService: CustomerService
  ) { }

  ngOnInit() {
    this.customerList$ = this.customerService.retrieveCustomers();
  }

}
