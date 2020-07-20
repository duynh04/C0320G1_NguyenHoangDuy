import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms'
import { EmployeeService } from '../employee.service';
import { IEmployee } from '../models/employee';
import { UserValidatorService } from 'src/app/shared/user-validator.service'
import { Observable, Subscription } from 'rxjs';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-employee-edit',
  templateUrl: './employee-edit.component.html',
  styleUrls: ['./employee-edit.component.scss']
})
export class EmployeeEditComponent implements OnInit {

  POSITION = ['Staff', 'Supervisor', 'Manager'];
  BACKGROUND = ['Bachelor', 'Master', 'Other'];
  employee$: Observable<IEmployee>;
  sub: Subscription;
  sub1: Subscription;
  editForm: FormGroup;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private fb: FormBuilder,
    public userValidatorService: UserValidatorService,
    private employeeService: EmployeeService
  ) { }

  ngOnInit() {
    this.editForm = this.fb.group({
      id: ['', [Validators.required, Validators.pattern('^NV-\\d{4}$')]],
      name: [''],
      birthday: [new Date()],
      email: [''],
      idCard: [''],
      phone: [''],
      salary: [''],
      position: ['Staff'],
      edu_bg: ['Other'],
    });
    this.sub = this.route.paramMap.pipe(
      switchMap((param: ParamMap) => this.employeeService.findById(param.get('id')))
    ).subscribe((employee: IEmployee | undefined) => {
      if (employee) {
        this.editForm.patchValue(employee);
      }
    });
  }

  onSubmit() {
    let data: IEmployee = this.editForm.value as IEmployee;
    this.sub1 = this.employeeService.update(data).subscribe(
      (data: IEmployee) => {
        this.goBack();
      },
      (error: any) => console.error(error)
    );
  }
  ngOnDestroy() {
    this.sub.unsubscribe();
    if (this.sub1)
      this.sub1.unsubscribe();
  }
  goBack() {
    this.router.navigate(['/employees'], { relativeTo: this.route })
  }

  get code() {
    return this.editForm.get('id');
  }
  get birthday() {
    return this.editForm.get('birthday');
  }
}
