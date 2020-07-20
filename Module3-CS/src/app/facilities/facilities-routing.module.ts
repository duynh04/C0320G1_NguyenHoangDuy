import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FacilityListComponent } from './facility-list/facility-list.component';
import { FacilityCenterComponent } from './facility-center/facility-center.component';
import { FacilityDetailComponent } from './facility-detail/facility-detail.component';
import { FacilityEditComponent } from './facility-edit/facility-edit.component';
import { FacilityCreateComponent } from './facility-create/facility-create.component';


const routes: Routes = [
  {
    path: '', component: FacilityCenterComponent,
    children: [
      { path: '', component: FacilityListComponent },
      { path: 'detail/:id', component: FacilityDetailComponent },
      { path: 'edit/:id', component: FacilityEditComponent },
      { path: 'create', component: FacilityCreateComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FacilitiesRoutingModule { }
