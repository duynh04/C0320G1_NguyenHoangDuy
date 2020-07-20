import { Component, OnInit, OnDestroy } from '@angular/core';
import { ICustomer } from '../models/customer';
import { CustomerService } from '../customer.service';
import { Observable, Subscription } from 'rxjs';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.scss']
})
export class CustomerListComponent implements OnInit, OnDestroy {

  p: number = 1;
  customerList$: Observable<ICustomer[]>;
  sub: Subscription;
  constructor(
    private customerService: CustomerService
  ) { }

  ngOnInit() {
    this.customerList$ = this.customerService.getAll();
  }
  ngOnDestroy() {
    if (this.sub)
      this.sub.unsubscribe();
  }
  del(id: string) {
    this.sub = this.customerService.delete(id).subscribe(
      null,
      (error: any) => console.error(error)
    )
  }
}
