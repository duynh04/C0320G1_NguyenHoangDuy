import { Component, OnInit } from '@angular/core';
import { Icontent } from './../../bds/icontent';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-popup',
  templateUrl: './popup.component.html',
  styleUrls: ['./popup.component.scss']
})
export class PopupComponent implements OnInit {

  fullContent: Icontent;

  constructor(
    private modal: NgbActiveModal
  ) { }

  ngOnInit() {
  }

  onCancel() {
    this.modal.dismiss("");
  }
  sayYes() {
    this.modal.close("ok");
  }
}
