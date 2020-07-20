import { Component, OnInit, OnDestroy } from '@angular/core';
import { ParamMap } from '@angular/router';
import { FacilityService } from '../facility.service';
import { Observable, Subscription } from 'rxjs';
import { IFacility } from '../models/facility';

@Component({
  selector: 'app-facility-list',
  templateUrl: './facility-list.component.html',
  styleUrls: ['./facility-list.component.scss']
})
export class FacilityListComponent implements OnInit, OnDestroy {

  p: number = 1;
  facilityList$: Observable<IFacility[]>;
  sub: Subscription;
  constructor(
    private facilityService: FacilityService
  ) { }

  ngOnInit() {
    this.facilityList$ = this.facilityService.getAll();
  }
  ngOnDestroy() {
    if (this.sub)
      this.sub.unsubscribe();
  }
  del(id: string) {
    this.sub = this.facilityService.delete(id).subscribe(
      null,
      (error: any) => console.error(error)
    )
  }
}
