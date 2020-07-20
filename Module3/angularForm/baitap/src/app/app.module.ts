import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { RegisterRfComponent } from "./register-rf/register-rf.component";
import { LoginTdfComponent } from "./login-tdf/login-tdf.component";
import { EmailValidatorDirective } from './shared/email-validator.directive';

@NgModule({
  declarations: [
    AppComponent,
    RegisterRfComponent,
    LoginTdfComponent,
    EmailValidatorDirective,
  ],
  imports: [BrowserModule, AppRoutingModule, ReactiveFormsModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule { }
