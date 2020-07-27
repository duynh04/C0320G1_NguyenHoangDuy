import { Component, OnInit, OnDestroy } from '@angular/core';
import { BdsService } from './../bds.service';
import { Icontent } from './../icontent';
import { Subscription } from 'rxjs';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-bds-list',
  templateUrl: './bds-list.component.html',
  styleUrls: ['./bds-list.component.scss']
})
export class BdsListComponent implements OnInit, OnDestroy {

  confirm: NgbModalRef
  bdsList: Icontent[];
  sub: Subscription
  term: string;
  p = 1;
  constructor(
    private bdsService: BdsService,
    private modalService: NgbModal
  ) { }

  ngOnInit() {
    this.sub = this.bdsService.getAll().subscribe(
      (data) => this.bdsList = data
    )
  }
  ngOnDestroy() {
    if (this.sub)
      this.sub.unsubscribe();
  }
  // openSearchPopup() {
  //   this.confirm = this.modalService.open(SearchPopupComponent);
  //   this.confirm.result.then(
  //     data => this.term = data
  //   ).catch(error => console.log(error))
  // }
}
