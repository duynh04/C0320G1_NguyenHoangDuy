import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/customers/customer.service';

@Component({
  selector: 'app-contract-center',
  templateUrl: './contract-center.component.html',
  styleUrls: ['./contract-center.component.scss']
})
export class ContractCenterComponent implements OnInit {

  cross2: number;
  constructor(
    private cust: CustomerService
  ) { }

  ngOnInit() {
  }

}
