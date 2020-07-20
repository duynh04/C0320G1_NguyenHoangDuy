import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { Observable } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { IEmployee } from '../models/employee';
import { EmployeeService } from '../employee.service';
@Component({
  selector: 'app-employee-detail',
  templateUrl: './employee-detail.component.html',
  styleUrls: ['./employee-detail.component.scss']
})
export class EmployeeDetailComponent implements OnInit {

  employee$: Observable<IEmployee>;
  constructor(
    private customerService: EmployeeService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.employee$ = this.route.paramMap.pipe(
      switchMap((param: ParamMap) => this.customerService.findById(param.get('id')))
    );
  }

  goBack() {
    console.log(this.route);
    this.router.navigate(['/employees'], { relativeTo: this.route })
  }
}
