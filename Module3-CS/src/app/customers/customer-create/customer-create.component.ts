import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ICustomer } from '../models/customer';
import { CustomerType } from '../models/customer-type.enum';
import { CustomerService } from '../customer.service';
import { UserValidatorService, uniqueEmail } from './../../shared/user-validator.service';
import { Subscription } from 'rxjs';
import { Router, ActivatedRoute } from '@angular/router';
import { FormatterService } from './../../shared/formatter.service';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.scss']
})
export class CustomerCreateComponent implements OnInit, OnDestroy {

  types: string[] = [CustomerType.MEMBER, CustomerType.SILVER, CustomerType.GOLD, CustomerType.PLANTINUM, CustomerType.DIAMOND];
  registerForm: FormGroup;
  sub: Subscription;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private fb: FormBuilder,
    private customerService: CustomerService,
    // private userValidatorService: UserValidatorService,
    private formatterService: FormatterService
  ) { }

  ngOnInit() {
    this.registerForm = this.fb.group({
      id: ['', [Validators.required, Validators.pattern(/^KH-\d{4}$/)]],
      name: ['', [Validators.required, Validators.pattern(/^([A-Z][a-z]+\s?)+$/)]],
      birthday: [new Date(), [UserValidatorService.IsUnder(18)]],
      email: ['', [Validators.required, Validators.pattern(/^([-\w.])+[a-zA-Z\d]@(\w+\.)+(\w+)$/)], [uniqueEmail(this.customerService)]],
      idCard: ['', [Validators.required, Validators.pattern(/^\d{9}$/)]],
      phone: ['', [Validators.pattern(/^$|^((\(\+84\))|0)9[01]\d{7}$/)]],
      type: ['Member']
    })
  }
  onSubmit() {
    let data: ICustomer = this.registerForm.value as ICustomer;
    data.birthday = this.formatterService.FormatDate(this.birthday.value);
    this.sub = this.customerService.add(data).subscribe(
      (obj: ICustomer) => {
        return this.router.navigate(['/customers'], { relativeTo: this.route })
      },
      (error: any) => console.error(error)
    );
  }

  ngOnDestroy() {
    if (this.sub)
      this.sub.unsubscribe();
  }
  //getter
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
}

