import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { Observable } from 'rxjs';
import { switchMap } from 'rxjs/operators'
import { IFacility } from '../models/facility';
import { FacilityService } from '../facility.service';
@Component({
  selector: 'app-facility-detail',
  templateUrl: './facility-detail.component.html',
  styleUrls: ['./facility-detail.component.scss']
})
export class FacilityDetailComponent implements OnInit {

  facility$: Observable<IFacility>;
  constructor(
    private facilityService: FacilityService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.facility$ = this.route.paramMap.pipe(
      switchMap((param: ParamMap) => this.facilityService.findById(param.get('id')))
    );
  }

  goBack() {
    this.router.navigate(['/facilities'], { relativeTo: this.route })
  }
}
