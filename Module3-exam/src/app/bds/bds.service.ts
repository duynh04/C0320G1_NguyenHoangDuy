import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Icontent } from './icontent';

@Injectable({
  providedIn: 'root'
})
export class BdsService {
  private apiEndpointUri = 'http://localhost:3000/bds'
  constructor(
    private http: HttpClient
  ) { }

  getAll(): Observable<Icontent[]> {
    return this.http.get<Icontent[]>(this.apiEndpointUri);
  }

  add(_content: Icontent): Observable<Icontent> {
    return this.http.post<Icontent>(this.apiEndpointUri, _content);
  }
}
