import { Injectable } from '@angular/core';
import { ICustomer } from '../models/customer';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { templateJitUrl } from '@angular/compiler';
@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  constructor(private http: HttpClient) { }

  retrieveCustomers(): Observable<ICustomer[]> {
    return this.http.get<ICustomer[]>('assets/customers.json');
  }
  getCustomerById(_id: string): Observable<ICustomer> {
    return this.retrieveCustomers().pipe(
      map((data: ICustomer[]) => {
        const temp = data.find(value => value.id === _id);
        console.log(temp);
        return temp;
      })
    );
  }
}
