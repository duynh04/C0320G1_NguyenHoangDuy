import { Component, OnInit, OnDestroy } from '@angular/core';
import { Observable, Subscription } from 'rxjs';
import { IEmployee } from '../models/employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.scss']
})
export class EmployeeListComponent implements OnInit, OnDestroy {

  p: number = 1;
  employeeList$: Observable<IEmployee[]>;
  sub: Subscription;
  constructor(private employeeService: EmployeeService) { }

  ngOnInit() {
    this.employeeList$ = this.employeeService.getAll();
  }
  ngOnDestroy() {
    console.log(this.sub);
    if (this.sub)
      this.sub.unsubscribe();
  }
  del(id: string) {
    this.sub = this.employeeService.delete(id).subscribe(
      null,
      (error: any) => console.error(error)
    )
  }
}
