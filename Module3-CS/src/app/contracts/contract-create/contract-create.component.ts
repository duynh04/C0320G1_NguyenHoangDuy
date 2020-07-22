import { Component, OnInit, OnDestroy } from '@angular/core';
import { ContractService } from './../contract.service';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { ICustomer } from './../../customers/models/customer';
import { Observable, Subscription } from 'rxjs';
import { IEmployee } from './../../employees/models/employee';
import { IFacility } from 'src/app/facilities/models/facility';
import { IContract } from './../models/contract';
import { UserValidatorService } from 'src/app/shared/user-validator.service';
import { identifierModuleUrl } from '@angular/compiler';
import { FormatterService } from './../../shared/formatter.service';
import { ActivatedRoute, PreloadAllModules, Router } from '@angular/router';

@Component({
  selector: 'app-contract-create',
  templateUrl: './contract-create.component.html',
  styleUrls: ['./contract-create.component.scss']
})
export class ContractCreateComponent implements OnInit, OnDestroy {

  customerList$: Observable<ICustomer[]>;
  employeeList$: Observable<IEmployee[]>;
  facilityList$: Observable<IFacility[]>;
  sub: Subscription;
  sub1: Subscription;
  priceUnit: number;
  totalPrice: number;
  createForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private contractService: ContractService,
    private userValidatorService: UserValidatorService,
    private formatterService: FormatterService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    this.customerList$ = this.contractService.getCustomerList();
    this.employeeList$ = this.contractService.getEmployeeList();
    this.facilityList$ = this.contractService.getFacilityList();
    this.createForm = this.fb.group({
      customerCode: ['', [Validators.required]],
      employeeCode: ['', [Validators.required]],
      facilityCode: ['', [Validators.required]],
      date: this.fb.group({
        start: [new Date(), [this.userValidatorService.date]],
        end: [new Date(), [this.userValidatorService.date]]
      }, {
        validators: [this.userValidatorService.compare('date')]
      }),
      price: this.fb.group({
        deposit: ['0', [Validators.min(0)]],
        total: ['0']
      }, {
        validators: [this.userValidatorService.compare('number')]
      })
    });
    this.calcPrice();
  }

  onSubmit() {
    let contract: IContract = this.createForm.value as IContract;
    contract.date.start = this.formatterService.FormatDate(this.from.value);
    contract.date.end = this.formatterService.FormatDate(this.to.value);
    this.calcPrice();
    this.sub = this.contractService.add(contract).subscribe(
      (_) => this.router.navigate(['/contracts'], { relativeTo: this.route })
    );
  }

  ngOnDestroy() {
    this.sub1.unsubscribe();
    if (this.sub)
      this.sub.unsubscribe();
  }
  calcPrice() {
    let _id = this.facilityCode.value;
    console.log(`id: ${_id}`)
    this.sub1 = this.contractService.getServiceUnit(_id).subscribe(
      (data: IFacility | null) => {
        // console.log(`data: ${data == null ? 0 : data.price}`);
        this.priceUnit = data == null ? 0 : data.price;
        const totalPrice = this.contractService.caclTotalPrice(this.from.value, this.to.value, this.priceUnit);
        this.createForm.patchValue({
          price: {
            total: totalPrice
          }
        })
      }
    );
  }
  //getter
  get customerCode() {
    return this.createForm.get('customerCode');
  }
  get employeeCode() {
    return this.createForm.get('employeeCode');
  }
  get facilityCode() {
    return this.createForm.get('facilityCode');
  }
  get date() {
    return this.createForm.get('date') as FormGroup;
  }
  get from() {
    return this.createForm.get('date.start') as FormGroup;
  }
  get to() {
    return this.createForm.get('date.end') as FormGroup;
  }
  get price() {
    return this.createForm.get('price') as FormGroup;
  }
  get deposit() {
    return this.createForm.get('price.deposit');
  }
  get total() {
    return this.createForm.get('price.total');
  }
}
