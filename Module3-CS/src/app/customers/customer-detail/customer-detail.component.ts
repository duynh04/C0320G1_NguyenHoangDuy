import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { CustomerService } from '../customer.service';
import { Observable } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { ICustomer } from '../models/customer';

@Component({
  selector: 'app-customer-detail',
  templateUrl: './customer-detail.component.html',
  styleUrls: ['./customer-detail.component.scss']
})
export class CustomerDetailComponent implements OnInit {

  customer$: Observable<ICustomer>;
  constructor(
    private customerService: CustomerService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.customer$ = this.route.paramMap.pipe(
      switchMap((param: ParamMap) => this.customerService.findById(param.get('id')))
    );
  }

  goBack() {
    this.router.navigate(['/customers'], { relativeTo: this.route })
  }
}
