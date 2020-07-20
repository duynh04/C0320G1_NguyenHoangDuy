import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
import { IFacility } from './models/facility';
import { CRUDRepository } from '../shared/repository/repository';
import { handler } from '../shared/error-handling';
@Injectable({
  providedIn: 'root'
})
export class FacilityService implements CRUDRepository<IFacility>{

  private apiEndpointUri = 'http://localhost:3000/facilities'
  constructor(private http: HttpClient) { }

  getAll(): Observable<IFacility[]> {
    return this.http.get<IFacility[]>(this.apiEndpointUri).pipe(
      catchError(handler)
    );
  }

  add(obj: IFacility): Observable<IFacility> {
    return this.http.post<IFacility>(this.apiEndpointUri, obj).pipe(
      catchError(handler)
    );
  }

  update(obj: IFacility): Observable<IFacility> {
    return this.http.put<IFacility>(this.apiEndpointUri + `/${obj.id}`, obj).pipe(
      catchError(handler)
    );
  }

  delete(_id: string): Observable<IFacility> {
    return this.http.delete<IFacility>(this.apiEndpointUri + `/${_id}`,).pipe(
      catchError(handler)
    );
  }
  findById(_id: string): Observable<IFacility | null> {
    return this.http.get<IFacility[]>(this.apiEndpointUri, { params: { id: _id } }).pipe(
      map((data: IFacility[]) => data.length == 0 ? null : data[0] as IFacility),
      catchError(handler)
    );
  }
}
