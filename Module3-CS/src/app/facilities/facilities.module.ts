import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgxPaginationModule } from 'ngx-pagination';
import { Ng2SearchPipeModule } from 'ng2-search-filter';

import { FacilitiesRoutingModule } from './facilities-routing.module';
import { FacilityDetailComponent } from './facility-detail/facility-detail.component';
import { FacilityCreateComponent } from './facility-create/facility-create.component';
import { FacilityListComponent } from './facility-list/facility-list.component';
import { FacilityEditComponent } from './facility-edit/facility-edit.component';
import { FacilityCenterComponent } from './facility-center/facility-center.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { SharedModule } from '../shared/shared.module';
import { DialogComponent } from '../shared/dialog/dialog.component';


@NgModule({
  declarations: [FacilityDetailComponent, FacilityCreateComponent, FacilityListComponent, FacilityEditComponent, FacilityCenterComponent],
  imports: [
    CommonModule,
    FacilitiesRoutingModule,
    ReactiveFormsModule,
    NgxPaginationModule,
    SharedModule,
    FormsModule,
    Ng2SearchPipeModule
  ],
  entryComponents: [DialogComponent]
})
export class FacilitiesModule { }
