import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BdsRoutingModule } from './bds-routing.module';
import { BdsCenterComponent } from './bds-center/bds-center.component';
import { BdsListComponent } from './bds-list/bds-list.component';
import { BdsCreateComponent } from './bds-create/bds-create.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { NgbPaginationModule, NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { Ng2SearchPipeModule } from 'ng2-search-filter'
import { NgxPaginationModule } from 'ngx-pagination';
import { SharedModule } from '../shared/shared.module';
import { PopupComponent } from '../shared/popup/popup.component';

@NgModule({
  declarations: [BdsCenterComponent, BdsListComponent, BdsCreateComponent],
  imports: [
    CommonModule,
    BdsRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    Ng2SearchPipeModule,
    NgxPaginationModule,
    SharedModule,
    NgbModule
  ],
  entryComponents: [PopupComponent]
})
export class BdsModule { }
