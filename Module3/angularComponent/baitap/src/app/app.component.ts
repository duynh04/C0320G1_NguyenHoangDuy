import { Component } from "@angular/core";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.scss"],
})
export class AppComponent {
  title = "baitap";
  countdownMsg: string = "";
  seconds = 20;
  remainingTime = 20;

  finishCountdown(isFinish: boolean) {
    if (isFinish) {
      this.countdownMsg = "Time's up";
    } else {
      this.countdownMsg = "";
    }
  }
}
