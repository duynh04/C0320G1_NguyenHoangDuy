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
  // console.log(`value valid: ${control.value}`);
  // for (const key in control.value) {
  //   console.log(`valid: key: ${key}`);
  // }
  const regex = /^([-\w.])+[a-zA-Z\d]@(\w+\.)+(\w+)$/;
  const verification = control.value;
  const isValid = regex.test(verification);
  // console.log(`valid: ${isValid}`);
  return isValid ? null : { notMatch: true };
};

export const PhoneValidator: ValidatorFn = (control: AbstractControl): ValidationErrors | null => {
  let errors: ValidationErrors = { 'length': 0 };
  const regex = /^\+84\d{9,10}$/;
  const verification = control.value;
  verification.forEach((element, i) => {
    if (!regex.test(element)) {
      errors[`${i}`] = true;
      errors['length']++;
    }
  });
  // console.log(errors);
  // console.log(errors['length']);

  return errors.length == 0 ? null : errors;
};