import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms'
import { EmployeeService } from '../employee.service';
import { IEmployee } from '../models/employee';
import { UserValidatorService } from 'src/app/shared/user-validator.service';
import { Subscription } from 'rxjs';
import { Router, ActivatedRoute } from '@angular/router';
import { FormatterService } from './../../shared/formatter.service';

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.scss']
})
export class EmployeeCreateComponent implements OnInit, OnDestroy {
  POSITION = ['Staff', 'Supervisor', 'Manager'];
  BACKGROUND = ['Bachelor', 'Master', 'Other']
  registerForm: FormGroup;
  sub: Subscription;
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private fb: FormBuilder,
    public userValidatorService: UserValidatorService,
    private employeeService: EmployeeService,
    private formatterService: FormatterService
  ) { }

  ngOnInit() {
    this.registerForm = this.fb.group({
      id: ['', [Validators.required, Validators.pattern('^NV-\\d{4}$')], [this.userValidatorService.unique(this.employeeService, 'code')]],
      name: ['', [Validators.required, Validators.pattern(/^([A-Z][a-z]+\s?)+$/)]],
      birthday: [new Date(), [this.userValidatorService.date, UserValidatorService.IsUnder(18)]],
      email: ['', [Validators.required, Validators.pattern(/^([-\w.])+[a-zA-Z\d]@(\w+\.)+(\w+)$/)], [this.userValidatorService.unique(this.employeeService, 'email')]],
      idCard: ['', [Validators.required, Validators.pattern(/^\d{9}$/)]],
      phone: ['', [Validators.pattern(/^$|^((\(\+84\))|0)9[01]\d{7}$/)]],
      salary: ['', [Validators.required, Validators.min(1)]],
      position: ['Staff'],
      edu_bg: ['Other'],
    })
  }

  onSubmit() {
    let data: IEmployee = this.registerForm.value as IEmployee;
    data.birthday = this.formatterService.FormatDate(this.birthday.value);
    this.sub = this.employeeService.add(data).subscribe(
      (obj: IEmployee) => {
        return this.router.navigate(['/employees'], { relativeTo: this.route })
      },
      (error: any) => console.error(error)
    );
  }
  ngOnDestroy() {
    if (this.sub)
      this.sub.unsubscribe();
  }
  get code() {
    return this.registerForm.get('id');
  }
  get name() {
    return this.registerForm.get('name');
  }
  get birthday() {
    return this.registerForm.get('birthday');
  }
  get email() {
    return this.registerForm.get('email');
  }
  get idCard() {
    return this.registerForm.get('idCard');
  }
  get phone() {
    return this.registerForm.get('phone');
  }
  get salary() {
    return this.registerForm.get('salary');
  }
}
