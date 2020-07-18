import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CustomerCenterComponent } from './customer-center/customer-center.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { CustomerDetailComponent } from './customer-detail/customer-detail.component';
import { CustomerEditComponent } from './customer-edit/customer-edit.component';
import { CustomerCreateComponent } from './customer-create/customer-create.component';

const routes: Routes = [
  {
    path: '', component: CustomerCenterComponent,
    children: [
      { path: '', component: CustomerListComponent },
      { path: 'detail/:id', component: CustomerDetailComponent },
      { path: 'edit/:id', component: CustomerEditComponent },
      { path: 'create', component: CustomerCreateComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CustomersRoutingModule { }
