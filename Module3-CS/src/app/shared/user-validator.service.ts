import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { switchMap, map } from 'rxjs/operators';
import { AsyncValidatorFn, AbstractControl, ValidationErrors, FormControl, ValidatorFn, FormGroup } from '@angular/forms';
import { CRUDRepository } from './repository';
import { differenceInYears } from 'date-fns'
import { CustomerService } from 'src/app/customers/customer.service';
@Injectable({
  providedIn: 'root'
})
export class UserValidatorService {
  constructor() { }

  unique<T>(service: CRUDRepository<T>, field: string): AsyncValidatorFn {
    return (control: FormControl): Observable<ValidationErrors | null> => {
      let _data: Observable<T | null>;
      switch (field) {
        case 'code':
          _data = service.findById(control.value);
          break;
        case 'email':
          // _data = service.findByEmail(control.value);
          break;
      };
      return _data.pipe(
        map((value: T | null) => { return value ? { taken: true } : null; }));
    };
  }

  date(control: AbstractControl): ValidationErrors | null {
    const _date = new Date(control.value);
    if (_date.toString() == 'Invalid Date') {
      return { invalidDate: true };
    }
    return null;
  }

  static IsUnder(age: number): ValidatorFn {
    return (control: AbstractControl): ValidationErrors | null =>
      differenceInYears(new Date(), new Date(control.value)) < age ? { under: true } : null;
  }
  compare(field: string): ValidatorFn {
    return (control: AbstractControl): ValidationErrors | null => {
      let isValid: boolean;
      // console.log('Dooo');
      switch (field) {
        case 'date':
          isValid = this.compareDate(control);
          break;
        case 'number':
          isValid = this.compareNumber(control);
          break;
      }
      return isValid ? null : { compare: true }
    }
  }

  private compareNumber(control: AbstractControl): boolean {
    const verification = control.value;
    return Number(verification.total) - Number(verification.deposit) > 0;
  }


  private compareDate(control: AbstractControl): boolean {
    const verification = control.value;
    const d1 = new Date(verification.start);
    const d2 = new Date(verification.end);
    return d2.valueOf() - d1.valueOf() > 0;
  }
}

export function uniqueEmail(service: CustomerService): AsyncValidatorFn {
  return (control: FormControl): Observable<ValidationErrors | null> => {
    return service.findByEmail(control.value).pipe(
      map((value) => { return value ? { taken: true } : null; })
    )
  };
}