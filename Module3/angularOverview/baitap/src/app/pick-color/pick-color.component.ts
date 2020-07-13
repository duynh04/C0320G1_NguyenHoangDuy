import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-pick-color",
  template: `
    <h2>Color Picker</h2>
    <div>
      <label>Chọn màu:</label>
      <input
        [value]="background"
        type="color"
        (change)="onChange($event.target.value)"
      />
    </div>

    <p>Output:</p>
    <div class="color-preview" [style.background]="background"></div>
  `,
  styleUrls: ["./pick-color.component.scss"],
})
export class PickColorComponent implements OnInit {
  background = "#00e067";
  constructor() {}

  ngOnInit() {}
  onChange(value) {
    this.background = value;
  }
}
