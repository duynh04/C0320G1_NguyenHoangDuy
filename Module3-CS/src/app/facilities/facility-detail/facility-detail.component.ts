import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { Observable } from 'rxjs';
import { switchMap } from 'rxjs/operators'
import { IFacility } from '../models/facility';
import { FacilityService } from '../facility.service';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
@Component({
  selector: 'app-facility-detail',
  templateUrl: './facility-detail.component.html',
  styleUrls: ['./facility-detail.component.scss']
})
export class FacilityDetailComponent implements OnInit {

  @Input()
  selectedId: string;
  facility$: Observable<IFacility>;
  facility: IFacility;
  constructor(
    private facilityService: FacilityService,
    private router: Router,
    private route: ActivatedRoute,
    private modal: NgbActiveModal
  ) { }

  ngOnInit() {
    console.log(this.selectedId)
    this.facilityService.findById(this.selectedId).subscribe(
      (data) => {
        this.facility = data
        console.table(data);
      });
    // this.facility$ = this.route.paramMap.pipe(
    //   switchMap((param: ParamMap) => this.facilityService.findById(param.get('id')))
    // );
  }

  goBack() {
    // this.router.navigate(['/facilities'], { relativeTo: this.route })
    this.modal.close();
  }
}
