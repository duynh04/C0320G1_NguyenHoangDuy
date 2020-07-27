import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { PopupComponent } from 'src/app/shared/popup/popup.component';
import { Icontent } from '../icontent';
import { BdsService } from '../bds.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-bds-create',
  templateUrl: './bds-create.component.html',
  styleUrls: ['./bds-create.component.scss']
})
export class BdsCreateComponent implements OnInit {

  DANH_MUC: string[] = ['Nhà đất', 'Phòng trọ', 'Nhà Trọ'];
  VUNG_MIEN: string[] = ['Hà Nội', 'Sài Gòn', 'Đà Nẵng'];
  createForm: FormGroup;
  confirm: NgbModalRef;
  constructor(
    private fb: FormBuilder,
    private modalService: NgbModal,
    private bdsService: BdsService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    this.createForm = this.fb.group({
      danhMuc: [''],
      vungMien: [''],
      toChuc: [''],
      dangTin: [''],
      tinhTrang: [''],
      diaChi: ['', [Validators.required]],
      dienTich: ['', [Validators.required, Validators.pattern(/^([2-9]\d)(\.\d+)?$|^([1-9][0-9]{2,})(\.\d+)?$/)]],
      huong: [''],
      tuaDe: ['', [Validators.required]],
      noiDung: ['', Validators.required],
      gia: ['0', [Validators.required, Validators.min(100000000)]]
    })
  }

  onSubmit() {
    let _fullContent: Icontent = this.createForm.value as Icontent;
    console.log(_fullContent)
    this.confirm = this.modalService.open(PopupComponent)
    this.confirm.componentInstance.fullContent = _fullContent;
    this.confirm.result.then(
      res => {
        console.log(_fullContent);
        this.bdsService.add(_fullContent).subscribe(
          () => this.router.navigate(['/bds'], { relativeTo: this.route })
        );
      }
    ).catch(error => console.error(error));
  }

  get diaChi() {
    return this.createForm.get('diaChi') as FormControl;
  }
  get dienTich() {
    return this.createForm.get('dienTich') as FormControl;
  }
  get tuaDe() {
    return this.createForm.get('tuaDe') as FormControl;
  }
  get noiDung() {
    return this.createForm.get('noiDung') as FormControl;
  }
  get gia() {
    return this.createForm.get('gia') as FormControl;
  }
}
