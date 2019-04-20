import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: 'customers',
    loadChildren: './customers/customers.module#CustomersModule'
  },
  {
    path: 'asesores',
    loadChildren: './asesores/asesores.module#AsesoresModule'
  },
  {
    path: 'customers/:id/tarjetas',
    loadChildren: './tarjetas/tarjetas.module#TarjetasModule'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
