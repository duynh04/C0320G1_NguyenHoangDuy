import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DictionaryListComponent } from './dictionary-list/dictionary-list.component';
import { DictionaryDetailComponent } from './dictionary-detail/dictionary-detail.component';

const routes: Routes = [
  {
    path: '', component: DictionaryListComponent,
    children: [
      { path: ':key', component: DictionaryDetailComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
