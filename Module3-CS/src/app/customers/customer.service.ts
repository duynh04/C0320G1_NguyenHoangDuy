import { Injectable } from '@angular/core';
import { ICustomer } from './models/customer';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { handler } from '../shared/error-handling';
import { CRUDRepository } from '../shared/repository';
@Injectable({
  providedIn: 'root'
})
export class CustomerService implements CRUDRepository<ICustomer>{

  // cross_prop: number;
  private apiEndpointUri = 'http://localhost:3000/customers'
  constructor(private http: HttpClient) {
    // this.cross_prop = -1;
  }

  getAll(): Observable<ICustomer[]> {
    return this.http.get<ICustomer[]>(this.apiEndpointUri).pipe(
      catchError(handler)
    );
  }

  add(obj: ICustomer): Observable<ICustomer> {
    return this.http.post<ICustomer>(this.apiEndpointUri, obj).pipe(
      catchError(handler)
    );
  }

  update(obj: ICustomer): Observable<ICustomer> {
    return this.http.put<ICustomer>(this.apiEndpointUri + `/${obj.id}`, obj).pipe(
      catchError(handler)
    );
  }

  delete(_id: string): Observable<any> {
    return this.http.delete(`${this.apiEndpointUri}/${_id}`);
  }

  findById(_id: string): Observable<ICustomer | null> {
    return this.http.get<ICustomer[]>(this.apiEndpointUri, { params: { id: _id } }).pipe(
      map((data: ICustomer[]) => data.length == 0 ? null : data[0] as ICustomer),
      catchError(handler)
    );
  }

  findByEmail(_email: string) {
    return this.http.get<ICustomer[]>(this.apiEndpointUri, { params: { 'email': _email } }).pipe(
      map((data: ICustomer[]) => data.length == 0 ? null : data[0] as ICustomer),
      catchError(handler)
    );
  }
}

