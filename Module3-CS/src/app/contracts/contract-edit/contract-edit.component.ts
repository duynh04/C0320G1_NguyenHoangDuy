import { Component, OnInit } from '@angular/core';
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
import { ActivatedRoute, Router } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-contract-edit',
  templateUrl: './contract-edit.component.html',
  styleUrls: ['./contract-edit.component.scss']
})
export class ContractEditComponent implements OnInit {

  customerList$: Observable<ICustomer[]>;
  employeeList$: Observable<IEmployee[]>;
  facilityList$: Observable<IFacility[]>;
  sub: Subscription[] = [];
  priceUnit: number;
  selectedId: string;
  editForm: FormGroup;
  constructor(
    private fb: FormBuilder,
    private contractService: ContractService,
    private userValidatorService: UserValidatorService,
    private formatterService: FormatterService,
    private route: ActivatedRoute,
    private router: Router,
    private modal: NgbActiveModal
  ) { }

  ngOnInit() {
    this.customerList$ = this.contractService.getCustomerList();
    this.employeeList$ = this.contractService.getEmployeeList();
    this.facilityList$ = this.contractService.getFacilityList();
    this.editForm = this.fb.group({
      customerCode: ['', [Validators.required]],
      employeeCode: ['', [Validators.required]],
      facilityCode: ['', [Validators.required]],
      date: this.fb.group({
        start: ['', [this.userValidatorService.date]],
        end: ['', [this.userValidatorService.date]]
      }, {
        validators: [this.userValidatorService.compare('date')]
      }),
      price: this.fb.group({
        deposit: ['', [Validators.min(0)]],
        total: ['']
      }, {
        validators: [this.userValidatorService.compare('number')]
      })
    });
    this.sub[0] = this.contractService.findById(this.selectedId).subscribe(
      (contract: IContract) => {
        // this.selectedId = contract.id;
        contract.date.start = this.formatterService.FormatDate(contract.date.start, false);
        contract.date.end = this.formatterService.FormatDate(contract.date.end, false);
        this.editForm.patchValue(contract);
      }
    )
  }
  onSubmit() {
    let contract: IContract = this.editForm.value as IContract;
    contract.date.start = this.formatterService.FormatDate(this.from.value);
    contract.date.end = this.formatterService.FormatDate(this.to.value);
    contract.id = this.selectedId;
    this.sub[1] = this.contractService.update(contract).subscribe(
      (data: IContract) => this.modal.close(data)
    );
  }

  ngOnDestroy() {
    this.sub.forEach(value => {
      if (value)
        value.unsubscribe();
    })
  }
  calcPrice() {
    let _id = this.facilityCode.value;
    this.sub[2] = this.contractService.getServiceUnit(_id).subscribe(
      (data: IFacility | null) => {
        this.priceUnit = data == null ? 0 : data.price;
        const totalPrice = this.contractService.caclTotalPrice(this.from.value, this.to.value, this.priceUnit);
        this.editForm.patchValue({
          price: {
            total: totalPrice
          }
        })
      }
    );
  }

  goBack() {
    // this.router.navigate(['/contracts'], { relativeTo: this.route })
    this.modal.dismiss('');
  }
  //getter
  get customerCode() {
    return this.editForm.get('customerCode');
  }
  get employeeCode() {
    return this.editForm.get('employeeCode');
  }
  get facilityCode() {
    return this.editForm.get('facilityCode');
  }
  get date() {
    return this.editForm.get('date') as FormGroup;
  }
  get from() {
    return this.editForm.get('date.start') as FormGroup;
  }
  get to() {
    return this.editForm.get('date.end') as FormGroup;
  }
  get price() {
    return this.editForm.get('price') as FormGroup;
  }
  get deposit() {
    return this.editForm.get('price.deposit');
  }
  get total() {
    return this.editForm.get('price.total');
  }
}
