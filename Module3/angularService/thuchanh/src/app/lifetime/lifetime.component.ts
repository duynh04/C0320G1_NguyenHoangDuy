import { Component, OnInit } from '@angular/core';
import { DateUtilService } from '../services/date-util.service';

@Component({
  selector: 'app-lifetime',
  templateUrl: './lifetime.component.html',
  styleUrls: ['./lifetime.component.scss']
})
export class LifetimeComponent implements OnInit {

  output: string;
  constructor(private dateUtilService: DateUtilService) { }

  ngOnInit() {
    this.output = '';
  }

  onChange(value: string) {
    this.output = this.dateUtilService.getDiffToNow(value);
  }

}
