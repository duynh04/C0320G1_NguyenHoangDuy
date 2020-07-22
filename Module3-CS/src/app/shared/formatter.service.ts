import { Injectable } from '@angular/core';
import { DatePipe } from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class FormatterService {

  constructor() { }

  FormatDate(obj: string, flag: boolean = true): string {
    if (flag) {
      const d = new DatePipe('en-US');
      return d.transform(obj, 'dd/MM/yyyy');
    } else {
      return obj.split("/").reverse().join("-");
    }
  }


}
