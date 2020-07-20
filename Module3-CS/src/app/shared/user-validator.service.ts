import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { switchMap, map } from 'rxjs/operators';
import { AsyncValidatorFn, AbstractControl, ValidationErrors, FormControl, ValidatorFn } from '@angular/forms';
import { CRUDRepository } from './repository/repository';
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
          _data = service.findByEmail(control.value);
          break;
      };
      return _data.pipe(
        map((value: T | null) => { return value ? { 'taken': true } : null; }));
    };
  }

  date(control: FormControl): ValidationErrors | null {
    const _date = new Date(control.value);
    if (_date.toString() == 'Invalid Date') {
      return { 'invalidDate': true };
    }
    return null;
  }
}
