import { Component, OnInit, OnDestroy } from '@angular/core';
import { ICustomer } from '../models/customer';
import { CustomerService } from '../customer.service';
import { Observable, Subscription } from 'rxjs';
import { map } from 'rxjs/operators';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { DialogComponent } from 'src/app/shared/dialog/dialog.component';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.scss']
})
export class CustomerListComponent implements OnInit, OnDestroy {

  // cross1: number;
  term: string;
  page: number = 1;
  pageSize: number = 5;
  collectionSize: number;
  customerList: ICustomer[];
  sub: Subscription[] = [];
  modalRef: NgbModalRef;
  constructor(
    public modalService: NgbModal,
    private customerService: CustomerService
  ) { }

  ngOnInit() {
    this.sub[0] = this.customerService.getAll().subscribe(
      (data: ICustomer[]) => {
        this.customerList = data
        this.collectionSize = this.customerList.length;
      });
  }

  ngOnDestroy() {
    this.sub.forEach(val => {
      if (val)
        val.unsubscribe();
    })
  }
  confirm(customer: ICustomer) {
    this.modalRef = this.modalService.open(DialogComponent);
    this.modalRef.componentInstance.message = customer.name;
    this.modalRef.componentInstance.code = customer.id;
    this.modalRef.result.then(
      (result: string) => this.del(result)
    ).catch(
      (error: string) => console.error(`error`)
    );
  }
  del(id: string) {
    this.sub[1] = this.customerService.delete(id).subscribe(
      () => this.customerList = this.customerList.filter(val => val.id !== id)
    )
  }
}
