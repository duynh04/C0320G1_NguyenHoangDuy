import { Component } from "@angular/core";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.scss"],
})
export class AppComponent {
  title = "thuchanh";
  parentEmail: string = "duy@gmail.com";
  parentPhone: string = "DUy";
}
