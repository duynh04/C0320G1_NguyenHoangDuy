import { Injectable } from '@angular/core';
import { CRUDRepository } from '../shared/repository';
import { IContract } from './models/contract';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { handler } from '../shared/error-handling';
import { CustomerService } from './../customers/customer.service';
import { EmployeeService } from '../employees/employee.service';
import { ICustomer } from '../customers/models/customer';
import { IEmployee } from '../employees/models/employee';
import { FacilityService } from '../facilities/facility.service';
import { IFacility } from './../facilities/models/facility';
import { FormatterService } from '../shared/formatter.service';

@Injectable({
  providedIn: 'root'
})
export class ContractService implements CRUDRepository<IContract>{

  private apiEndpointUri = 'http://localhost:3000/contracts'

  constructor(
    private http: HttpClient,
    private customerService: CustomerService,
    private employeeService: EmployeeService,
    private facilityService: FacilityService,
    private formatterService: FormatterService
  ) { }

  getCustomerList(): Observable<ICustomer[]> {
    return this.customerService.getAll();
  }
  getEmployeeList(): Observable<IEmployee[]> {
    return this.employeeService.getAll();
  }
  getFacilityList(): Observable<IFacility[]> {
    return this.facilityService.getAll();
  }

  getAll(): Observable<IContract[]> {
    return this.http.get<IContract[]>(this.apiEndpointUri).pipe(
      catchError(handler)
    );
  }

  add(obj: IContract): Observable<IContract> {
    return this.http.post<IContract>(this.apiEndpointUri, obj).pipe(
      catchError(handler)
    );
  }

  update(obj: IContract): Observable<IContract> {
    return this.http.put<IContract>(this.apiEndpointUri + `/${obj.id}`, obj).pipe(
      catchError(handler)
    );
  }

  delete(_id: string): Observable<IContract> {
    return this.http.delete<IContract>(this.apiEndpointUri + `/${_id}`,).pipe(
      catchError(handler)
    );
  }
  getServiceUnit(_id: string): Observable<IFacility | null> {
    return this.facilityService.findById(_id);
  }

  findById(_id: string): Observable<IContract | null> {
    return this.http.get<IContract[]>(this.apiEndpointUri, { params: { id: _id } }).pipe(
      map((data: IContract[]) => data.length == 0 ? null : data[0] as IContract),
      catchError(handler)
    );
  }

  caclTotalPrice(dateFrom: string, dateTo: string, unit: number = 0): number {
    let date_from = new Date(new Date(dateFrom).toDateString());
    // console.log(`from: ${date_from}`)
    let date_to = new Date(new Date(dateTo).toDateString());
    // console.log(`to: ${date_to}`)
    let nights = ((date_to.getTime() - date_from.getTime()) / 1000 / 60 / 60 / 24);
    let total = nights * unit;
    console.log(`total: ${total}`)
    return isNaN(total) ? 0 : total;
  }
}
