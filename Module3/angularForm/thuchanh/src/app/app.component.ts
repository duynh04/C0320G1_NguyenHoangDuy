import { Component } from "@angular/core";
import { ITodo } from "./itodo";
import { FormControl } from "@angular/forms";
let _id = 1;
@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.scss"],
})
export class AppComponent {
  userInput = new FormControl("");
  todos: Array<ITodo> = [];
  constructor() {}

  ngOnInit() {}

  onChange() {
    const { value } = this.userInput;
    if (value) {
      const todo: ITodo = {
        id: _id++,
        content: value,
        complete: false,
      };
      this.todos.push(todo);
      this.userInput.setValue("");
    }
  }

  toggleTodo(i: any) {
    this.todos[i].complete = !this.todos[i].complete;
  }
}
