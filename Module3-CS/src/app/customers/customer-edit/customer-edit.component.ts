import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { ICustomer } from '../models/customer';
import { CustomerType } from '../models/customer-type.enum';
import { Observable, Subscription } from 'rxjs';
import { switchMap } from 'rxjs/operators'
import { CustomerService } from '../customer.service';
import { UserValidatorService } from 'src/app/shared/user-validator.service';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.scss']
})
export class CustomerEditComponent implements OnInit, OnDestroy {

  types: string[] = [CustomerType.MEMBER, CustomerType.SILVER, CustomerType.GOLD, CustomerType.PLANTINUM, CustomerType.DIAMOND];
  customer$: Observable<ICustomer>;
  sub: Subscription;
  sub1: Subscription;
  editForm: FormGroup;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private fb: FormBuilder,
    private customerService: CustomerService,
    private userValidatorService: UserValidatorService
  ) { }

  ngOnInit() {
    this.editForm = this.fb.group({
      id: ['', [Validators.required, Validators.pattern(/^KH-\d{4}$/)]],
      name: ['', [Validators.required, Validators.pattern(/^([A-Z][a-z]+\s?)+$/)]],
      birthday: [new Date(), [this.userValidatorService.date]],
      email: ['', [Validators.required, Validators.pattern(/^([-\w.])+[a-zA-Z\d]@(\w+\.)+(\w+)$/)]],
      idCard: ['', [Validators.required, Validators.pattern(/^\d{9}$/)]],
      phone: ['', [Validators.pattern(/^$|^((\(\+84\))|0)9[01]\d{7}$/)]],
      type: ['']
    });
    this.sub = this.route.paramMap.pipe(
      switchMap((param: ParamMap) => this.customerService.findById(param.get('id')))
    ).subscribe((customer: ICustomer | undefined) => {
      if (customer) {
        this.editForm.patchValue(customer);
      }
    });
  }
  onSubmit() {
    let data: ICustomer = this.editForm.value as ICustomer;
    this.sub1 = this.customerService.update(data).subscribe(
      (data: ICustomer) => {
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
    this.router.navigate(['/customers'], { relativeTo: this.route })
  }

  get code() {
    return this.editForm.get('id');
  }
  get email() {
    return this.editForm.get('email');
  }
  get idCard() {
    return this.editForm.get('idCard');
  }
  get phone() {
    return this.editForm.get('phone');
  }
  get birthday() {
    return this.editForm.get('birthday');
  }
  get name() {
    return this.editForm.get('name');
  }
}

