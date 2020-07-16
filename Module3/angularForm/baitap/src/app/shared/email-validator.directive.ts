import { Directive, Input } from '@angular/core';
import { NG_VALIDATORS, Validator, AbstractControl, ValidationErrors } from "@angular/forms"
@Directive({
  selector: '[emailPattern]',
  providers: [{ provide: NG_VALIDATORS, useExisting: EmailValidatorDirective, multi: true }]
})
export class EmailValidatorDirective implements Validator {

  // @Input() email: string;
  constructor() { }

  validate(control: AbstractControl): ValidationErrors {
    const regex = /^([-\w.])+[a-zA-Z\d]@(\w+\.)+(\w+)$/;
    const verification = control.value;
    const isValid = regex.test(verification);
    // console.log(`valid: ${isValid}`);
    return isValid ? null : { notMatch: true };
  }
}
