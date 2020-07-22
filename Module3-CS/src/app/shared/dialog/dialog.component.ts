import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { NgbModal, ModalDismissReasons, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.scss']
})
export class DialogComponent implements OnInit {

  message: string;
  @Input() code: string;


  constructor(public modal: NgbActiveModal) { }

  ngOnInit() {
  }

  onCancel() {
    this.modal.dismiss("");
  }
  sayYes() {
    this.modal.close(this.code);
  }
}
