import { Component, OnInit, OnDestroy } from '@angular/core';
import { Observable, Subscription } from 'rxjs'
import { IContract } from '../models/contract';
import { ContractService } from '../contract.service';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { DialogComponent } from 'src/app/shared/dialog/dialog.component';

@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.scss']
})
export class ContractListComponent implements OnInit, OnDestroy {

  term: string;
  p: number = 1;
  contractList: IContract[];
  sub: Subscription[] = [];
  modalRef: NgbModalRef;
  constructor(
    public modalService: NgbModal,
    private contractService: ContractService
  ) { }

  ngOnInit() {
    this.sub[0] = this.contractService.getAll().subscribe(
      (data: IContract[]) => this.contractList = data
    );
  }
  ngOnDestroy() {
    this.sub.forEach(val => {
      if (val)
        val.unsubscribe();
    })
  }
  confirm(contract: IContract) {
    this.modalRef = this.modalService.open(DialogComponent);
    this.modalRef.componentInstance.message = "";
    this.modalRef.componentInstance.code = contract.id;
    this.modalRef.result.then(
      (result: string) => this.del(result)
    ).catch(
      (error: string) => console.error(`error`)
    );
  }
  del(id: string) {
    this.sub[1] = this.contractService.delete(id).subscribe(
      () => this.contractList = this.contractList.filter(val => val.id !== id)
    )
  }
}
