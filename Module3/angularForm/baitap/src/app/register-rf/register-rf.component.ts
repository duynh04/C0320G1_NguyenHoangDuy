import { Component, OnInit } from "@angular/core";
import { FormBuilder, Validators, FormArray, FormGroup } from "@angular/forms";
import { PasswordValidator, EmailValidator } from "../shared/validator";
@Component({
  selector: "app-register-rf",
  templateUrl: "./register-rf.component.html",
  styleUrls: ["./register-rf.component.scss"],
})
export class RegisterRfComponent implements OnInit {
  registerForm = this.fb.group({
    email: ['', [Validators.required, EmailValidator]],
    password: this.fb.group(
      {
        input: ['', [Validators.required]],
        confirm: ['', [Validators.required]],
      },
      { validators: PasswordValidator }
    ),
    country: [''],
    age: ['', [Validators.min(0), Validators.max(100)]],
    gender: [''],
    phones: this.fb.array([this.fb.control('', [Validators.pattern(/^\+84\d{9,10}$/)])]),
  });

  constructor(private fb: FormBuilder) { }

  get age() {
    return this.registerForm.get('age');
  }
  get password() {
    return this.registerForm.get('password') as FormGroup;
  }
  get email() {
    return this.registerForm.get('email');
  }
  get phones() {
    return this.registerForm.get('phones') as FormArray;
  }
  addPhone() {
    this.phones.push(this.fb.control('', [Validators.pattern(/^\+84\d{9,10}$/)]));
  }
  ngOnInit() { }

  onSubmit() {
    // TODO: Use EventEmitter with form value
    console.warn(this.registerForm.value);
  }
}
