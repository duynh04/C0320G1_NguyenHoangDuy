import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ContractsRoutingModule } from './contracts-routing.module';
import { ContractCenterComponent } from './contract-center/contract-center.component';
import { ContractCreateComponent } from './contract-create/contract-create.component';
import { ContractDetailComponent } from './contract-detail/contract-detail.component';
import { ContractEditComponent } from './contract-edit/contract-edit.component';
import { ContractListComponent } from './contract-list/contract-list.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { NgxPaginationModule } from 'ngx-pagination';
import { SharedModule } from '../shared/shared.module';
import { DialogComponent } from '../shared/dialog/dialog.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { FacilityDetailComponent } from '../facilities/facility-detail/facility-detail.component';
import { FacilitiesModule } from '../facilities/facilities.module';


@NgModule({
  declarations: [ContractCenterComponent, ContractCreateComponent, ContractDetailComponent, ContractEditComponent, ContractListComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    NgxPaginationModule,
    ContractsRoutingModule,
    SharedModule,
    FormsModule,
    Ng2SearchPipeModule,
    FacilitiesModule
  ],
  entryComponents: [DialogComponent, ContractEditComponent, FacilityDetailComponent]
})
export class ContractsModule { }
