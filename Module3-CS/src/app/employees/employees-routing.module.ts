import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeCenterComponent } from './employee-center/employee-center.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { EmployeeDetailComponent } from './employee-detail/employee-detail.component';
import { EmployeeEditComponent } from './employee-edit/employee-edit.component';
import { EmployeeCreateComponent } from './employee-create/employee-create.component';


const routes: Routes = [
  {
    path: '', component: EmployeeCenterComponent,
    children: [
      { path: '', component: EmployeeListComponent },
      { path: 'detail/:id', component: EmployeeDetailComponent },
      { path: 'edit/:id', component: EmployeeEditComponent },
      { path: 'create', component: EmployeeCreateComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EmployeesRoutingModule { }
