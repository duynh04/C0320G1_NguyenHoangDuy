import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { FontSizeComponent } from "./font-size/font-size.component";
import { ShowPetComponent } from "./show-pet/show-pet.component";

@NgModule({
  declarations: [AppComponent, FontSizeComponent, ShowPetComponent],
  imports: [BrowserModule, AppRoutingModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
