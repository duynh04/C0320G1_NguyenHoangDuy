import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BdsCenterComponent } from './bds-center/bds-center.component';
import { BdsCreateComponent } from './bds-create/bds-create.component';
import { BdsListComponent } from './bds-list/bds-list.component';


const routes: Routes = [
  {
    path: '', component: BdsCenterComponent,
    children: [
      { path: '', component: BdsListComponent },
      { path: 'create', component: BdsCreateComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BdsRoutingModule { }
