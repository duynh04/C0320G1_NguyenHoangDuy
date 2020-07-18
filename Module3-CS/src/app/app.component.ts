import { Component, OnInit } from '@angular/core';
import { Observable, of, from } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { ICustomer } from './customers/models/customer';
import { CustomerType } from './customers/models/customer-type.enum';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  constructor() { }
  ngOnInit() {
  }

}
