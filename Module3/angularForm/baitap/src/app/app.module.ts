import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { RegisterRfComponent } from "./register-rf/register-rf.component";
import { LoginRfComponent } from "./login-rf/login-rf.component";
import { LoginTdfComponent } from "./login-tdf/login-tdf.component";
import { RegisterTdfComponent } from "./register-tdf/register-tdf.component";

@NgModule({
  declarations: [
    AppComponent,
    RegisterRfComponent,
    LoginRfComponent,
    LoginTdfComponent,
    RegisterTdfComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, ReactiveFormsModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule { }
