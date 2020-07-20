import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgxPaginationModule } from 'ngx-pagination';

import { EmployeesRoutingModule } from './employees-routing.module';
import { EmployeeCenterComponent } from './employee-center/employee-center.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { EmployeeDetailComponent } from './employee-detail/employee-detail.component';
import { EmployeeEditComponent } from './employee-edit/employee-edit.component';
import { EmployeeCreateComponent } from './employee-create/employee-create.component';
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [EmployeeCenterComponent, EmployeeListComponent, EmployeeDetailComponent, EmployeeEditComponent, EmployeeCreateComponent],
  imports: [
    CommonModule,
    EmployeesRoutingModule,
    ReactiveFormsModule,
    NgxPaginationModule
  ]
})
export class EmployeesModule { }
