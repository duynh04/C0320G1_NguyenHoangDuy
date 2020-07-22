import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ContractCenterComponent } from './contract-center/contract-center.component';
import { ContractListComponent } from './contract-list/contract-list.component';
import { ContractDetailComponent } from './contract-detail/contract-detail.component';
import { ContractEditComponent } from './contract-edit/contract-edit.component';
import { ContractCreateComponent } from './contract-create/contract-create.component';


const routes: Routes = [
  {
    path: '', component: ContractCenterComponent,
    children: [
      { path: '', component: ContractListComponent },
      { path: 'detail/:id', component: ContractDetailComponent },
      { path: 'edit/:id', component: ContractEditComponent },
      { path: 'create', component: ContractCreateComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ContractsRoutingModule { }
