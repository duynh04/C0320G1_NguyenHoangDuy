import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormsModule } from "@angular/forms";
import { NgxPaginationModule } from 'ngx-pagination';
import { CustomersRoutingModule } from './customers-routing.module';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { CustomerDetailComponent } from './customer-detail/customer-detail.component';
import { CustomerCenterComponent } from './customer-center/customer-center.component';
import { CustomerCreateComponent } from './customer-create/customer-create.component';
import { CustomerEditComponent } from './customer-edit/customer-edit.component';
import { SharedModule } from '../shared/shared.module';
import { DialogComponent } from '../shared/dialog/dialog.component';
import { NgbPaginationModule } from '@ng-bootstrap/ng-bootstrap';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
@NgModule({
  declarations: [CustomerListComponent, CustomerDetailComponent, CustomerCenterComponent, CustomerCreateComponent, CustomerEditComponent],
  imports: [
    CommonModule,
    CustomersRoutingModule,
    ReactiveFormsModule,
    NgxPaginationModule,
    SharedModule,
    NgbPaginationModule,
    Ng2SearchPipeModule,
    FormsModule
  ],
  entryComponents: [DialogComponent]
})
export class CustomersModule { }
