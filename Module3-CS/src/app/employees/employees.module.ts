import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgxPaginationModule } from 'ngx-pagination';

import { EmployeesRoutingModule } from './employees-routing.module';
import { EmployeeCenterComponent } from './employee-center/employee-center.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { EmployeeDetailComponent } from './employee-detail/employee-detail.component';
import { EmployeeEditComponent } from './employee-edit/employee-edit.component';
import { EmployeeCreateComponent } from './employee-create/employee-create.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { SharedModule } from '../shared/shared.module';
import { DialogComponent } from '../shared/dialog/dialog.component';
import { NgbPaginationModule } from '@ng-bootstrap/ng-bootstrap';
import { Ng2SearchPipeModule } from 'ng2-search-filter'

@NgModule({
  declarations: [EmployeeCenterComponent, EmployeeListComponent, EmployeeDetailComponent, EmployeeEditComponent, EmployeeCreateComponent],
  imports: [
    CommonModule,
    EmployeesRoutingModule,
    ReactiveFormsModule,
    NgxPaginationModule,
    SharedModule,
    NgbPaginationModule,
    FormsModule,
    Ng2SearchPipeModule
  ],
  entryComponents: [DialogComponent]
})
export class EmployeesModule { }
