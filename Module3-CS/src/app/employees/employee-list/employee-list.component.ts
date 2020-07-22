import { Component, OnInit, OnDestroy } from '@angular/core';
import { Observable, Subscription } from 'rxjs';
import { IEmployee } from '../models/employee';
import { EmployeeService } from '../employee.service';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { DialogComponent } from 'src/app/shared/dialog/dialog.component';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.scss']
})
export class EmployeeListComponent implements OnInit, OnDestroy {

  term: string
  //pagingation
  page: number = 1;
  pageSize: number = 5;
  collectionSize: number;
  employeeList: IEmployee[];
  sub: Subscription[] = [];
  modalRef: NgbModalRef;
  constructor(
    public modalService: NgbModal,
    private employeeService: EmployeeService
  ) { }

  ngOnInit() {
    this.sub[0] = this.employeeService.getAll().subscribe(
      (data: IEmployee[]) => {
        this.employeeList = data
        this.collectionSize = this.employeeList.length
      });
  }
  ngOnDestroy() {
    this.sub.forEach(val => {
      if (val)
        val.unsubscribe();
    })
  }
  confirm(employee: IEmployee) {
    this.modalRef = this.modalService.open(DialogComponent);
    this.modalRef.componentInstance.message = employee.name;
    this.modalRef.componentInstance.code = employee.id;
    this.modalRef.result.then(
      (result: string) => this.del(result)
    ).catch(
      (error: string) => console.error(`error`)
    );
  }
  del(id: string) {
    this.sub[1] = this.employeeService.delete(id).subscribe(
      () => this.employeeList = this.employeeList.filter(val => val.id !== id)
    )
  }
}
