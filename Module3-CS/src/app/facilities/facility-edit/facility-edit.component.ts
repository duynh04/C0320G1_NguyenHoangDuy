import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserValidatorService } from './../../shared/user-validator.service';
import { FacilityService } from '../facility.service';
import { IFacility } from '../models/facility';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { Subscription } from 'rxjs';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-facility-edit',
  templateUrl: './facility-edit.component.html',
  styleUrls: ['./facility-edit.component.scss']
})
export class FacilityEditComponent implements OnInit, OnDestroy {
  types: string[] = ['Room', 'House', 'Villa'];
  editForm: FormGroup;
  sub: Subscription;
  sub1: Subscription;
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private fb: FormBuilder,
    private facilityService: FacilityService,
    public userValidatorService: UserValidatorService
  ) { }

  ngOnInit() {
    this.editForm = this.fb.group({
      id: ['', [Validators.required, Validators.pattern('^DV-\\d{4}$')]],
      name: ['', [Validators.required]],
      area: ['', [Validators.required, Validators.min(30), Validators.max(1000)]],
      floor: ['', [Validators.required, Validators.min(1), Validators.max(10)]],
      persons: ['', [Validators.required, Validators.min(1), Validators.max(20)]],
      price: ['', [Validators.required, Validators.min(1)]],
      type: ['']
    });
    this.sub = this.route.paramMap.pipe(
      switchMap((param: ParamMap) => this.facilityService.findById(param.get('id')))
    ).subscribe((facility: IFacility | undefined) => {
      if (facility) {
        this.editForm.patchValue(facility);
      }
    });
  }
  onSubmit() {
    let data: IFacility = this.editForm.value as IFacility;
    this.sub1 = this.facilityService.update(data).subscribe(
      (obj: IFacility) => {
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
    this.router.navigate(['/facilities'], { relativeTo: this.route });
  }
  get code() {
    return this.editForm.get('id');
  }
  get name() {
    return this.editForm.get('name');
  }
  get area() {
    return this.editForm.get('area');
  }
  get floor() {
    return this.editForm.get('floor');
  }
  get persons() {
    return this.editForm.get('persons');
  }
  get price() {
    return this.editForm.get('price');
  }
}
