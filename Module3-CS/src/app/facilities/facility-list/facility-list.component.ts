import { Component, OnInit, OnDestroy } from '@angular/core';
import { ParamMap } from '@angular/router';
import { FacilityService } from '../facility.service';
import { Observable, Subscription } from 'rxjs';
import { IFacility } from '../models/facility';
import { map } from 'rxjs/operators';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { DialogComponent } from 'src/app/shared/dialog/dialog.component';

@Component({
  selector: 'app-facility-list',
  templateUrl: './facility-list.component.html',
  styleUrls: ['./facility-list.component.scss']
})
export class FacilityListComponent implements OnInit, OnDestroy {

  // cross1: number;
  term: string;
  p: number = 1;
  facilityList: IFacility[];
  sub: Subscription[] = [];
  modalRef: NgbModalRef;
  constructor(
    public modalService: NgbModal,
    private facilityService: FacilityService
  ) { }

  ngOnInit() {
    this.sub[0] = this.facilityService.getAll().subscribe(
      (data: IFacility[]) => this.facilityList = data
    );
  }

  ngOnDestroy() {
    this.sub.forEach(val => {
      if (val)
        val.unsubscribe();
    })
  }
  confirm(facility: IFacility) {
    this.modalRef = this.modalService.open(DialogComponent);
    this.modalRef.componentInstance.message = facility.name;
    this.modalRef.componentInstance.code = facility.id;
    this.modalRef.result.then(
      (result: string) => this.del(result)
    ).catch(
      (error: string) => console.error(`error`)
    );
  }
  del(id: string) {
    this.sub[1] = this.facilityService.delete(id).subscribe(
      () => this.facilityList = this.facilityList.filter(val => val.id !== id)
    )
  }
}
