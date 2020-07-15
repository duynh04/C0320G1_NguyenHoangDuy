import {
  Validators,
  ValidatorFn,
  AbstractControl,
  ValidationErrors,
  FormGroup,
} from "@angular/forms";

export const PasswordValidator: ValidatorFn = (
  control: AbstractControl
): ValidationErrors | null => {
  // for (const key in control.value) {
  //   console.log(`valid: key: ${key}`);
  // }
  const verification = control.value;
  const isTheSame = verification.input == verification.confirm;
  return isTheSame ? null : { notMatch: true };
};

export const EmailValidator: ValidatorFn = (control: AbstractControl): ValidationErrors | null => {
  console.log(`value valid: ${control.value}`);
  // for (const key in control.value) {
  //   console.log(`valid: key: ${key}`);
  // }
  const regex = /^([-\w.])+[a-zA-Z\d]@(\w+\.)+(\w+)$/;
  const verification = control.value;
  const isValid = regex.test(verification);
  console.log(`valid: ${isValid}`);
  return isValid ? null : { notMatch: true };
};