import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserValidatorService } from './../../shared/user-validator.service';
import { FacilityService } from '../facility.service';
import { IFacility } from '../models/facility';
import { Router, ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
@Component({
  selector: 'app-facility-create',
  templateUrl: './facility-create.component.html',
  styleUrls: ['./facility-create.component.scss']
})
export class FacilityCreateComponent implements OnInit, OnDestroy {

  types: string[] = ['Room', 'House', 'Villa'];
  registerForm: FormGroup;
  sub: Subscription;
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private fb: FormBuilder,
    private facilityService: FacilityService,
    public userValidatorService: UserValidatorService
  ) { }

  ngOnInit() {
    this.registerForm = this.fb.group({
      id: ['', [Validators.required, Validators.pattern('^DV-\\d{4}$')], [this.userValidatorService.unique(this.facilityService, 'code')]],
      name: ['', [Validators.required]],
      area: ['', [Validators.required, Validators.min(30), Validators.max(1000)]],
      floor: ['', [Validators.required, Validators.min(1), Validators.max(10)]],
      persons: ['', [Validators.required, Validators.min(1), Validators.max(20)]],
      price: ['', [Validators.required, Validators.min(1)]],
      type: ['Room']
    })
  }
  onSubmit() {
    let data: IFacility = this.registerForm.value as IFacility;
    this.sub = this.facilityService.add(data).subscribe(
      (obj: IFacility) => {
        return this.router.navigate(['/facilities'], { relativeTo: this.route })
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
  get area() {
    return this.registerForm.get('area');
  }
  get floor() {
    return this.registerForm.get('floor');
  }
  get persons() {
    return this.registerForm.get('persons');
  }
  get price() {
    return this.registerForm.get('price');
  }
}
