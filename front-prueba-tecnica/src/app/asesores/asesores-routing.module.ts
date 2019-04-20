import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AsesoresListComponent } from './containers/asesores-list/asesores-list.component';

const routes: Routes = [
  {
    path: '',
    component: AsesoresListComponent
  },
  {
    path: ':id/update',
    component: AsesoresListComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AsesoresRoutingModule {}
