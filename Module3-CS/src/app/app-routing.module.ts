import { NgModule } from '@angular/core';
import { Routes, RouterModule, PreloadAllModules } from '@angular/router';
import { HomeComponent } from './home/home.component';


const routes: Routes = [
  { path: '', component: HomeComponent },
  {
    path: 'customers', loadChildren: () => import('./customers/customers.module').then(mod => mod.CustomersModule)
  },
  {
    path: 'employees', loadChildren: () => import('./employees/employees.module').then(mod => mod.EmployeesModule)
  },
  {
    path: 'facilities', loadChildren: () => import('./facilities/facilities.module').then(mod => mod.FacilitiesModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    preloadingStrategy: PreloadAllModules
  })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
