import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgxPaginationModule } from 'ngx-pagination';

import { FacilitiesRoutingModule } from './facilities-routing.module';
import { FacilityDetailComponent } from './facility-detail/facility-detail.component';
import { FacilityCreateComponent } from './facility-create/facility-create.component';
import { FacilityListComponent } from './facility-list/facility-list.component';
import { FacilityEditComponent } from './facility-edit/facility-edit.component';
import { FacilityCenterComponent } from './facility-center/facility-center.component';
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [FacilityDetailComponent, FacilityCreateComponent, FacilityListComponent, FacilityEditComponent, FacilityCenterComponent],
  imports: [
    CommonModule,
    FacilitiesRoutingModule,
    ReactiveFormsModule,
    NgxPaginationModule
  ]
})
export class FacilitiesModule { }
