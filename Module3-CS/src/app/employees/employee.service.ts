import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
import { IEmployee } from './models/employee';
import { CRUDRepository } from '../shared/repository/repository';
import { handler } from '../shared/error-handling';


@Injectable({
  providedIn: 'root'
})
export class EmployeeService implements CRUDRepository<IEmployee> {
  private apiEndpointUri = 'http://localhost:3000/employees'
  constructor(private http: HttpClient) { }

  getAll(): Observable<IEmployee[]> {
    return this.http.get<IEmployee[]>(this.apiEndpointUri).pipe(
      catchError(handler)
    );
  }
  add(obj: IEmployee): Observable<IEmployee> {
    return this.http.post<IEmployee>(this.apiEndpointUri, obj).pipe(
      catchError(handler)
    );
  }

  update(obj: IEmployee): Observable<IEmployee> {
    return this.http.put<IEmployee>(this.apiEndpointUri + `/${obj.id}`, obj).pipe(
      catchError(handler)
    );
  }

  delete(_id: string): Observable<IEmployee> {
    return this.http.delete<IEmployee>(this.apiEndpointUri + `/${_id}`,).pipe(
      catchError(handler)
    );
  }

  findById(_id: string): Observable<IEmployee | null> {
    return this.http.get<IEmployee[]>(this.apiEndpointUri, { params: { id: _id } }).pipe(
      map((data: IEmployee[]) => data.length == 0 ? null : data[0] as IEmployee),
      catchError(handler)
    );
  }
  findByEmail(_email: string) {
    return this.http.get<IEmployee[]>(this.apiEndpointUri, { params: { 'email': _email } }).pipe(
      map((data: IEmployee[]) => data.length == 0 ? null : data[0] as IEmployee),
      catchError(handler)
    );
  }
}
