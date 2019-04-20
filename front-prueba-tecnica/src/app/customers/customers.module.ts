import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { CustomersRoutingModule } from './customers-routing.module';
import { CustomersListComponent } from './containers/customers-list/customers-list.component';
import { CustomersTableComponent } from './components/customers-table/customers-table.component';
import { CustomersFormComponent } from './components/customers-form/customers-form.component';
import { CustomerService } from './services/customer.service';

@NgModule({
  declarations: [
    CustomersListComponent,
    CustomersTableComponent,
    CustomersFormComponent
  ],
  imports: [
    CommonModule,
    CustomersRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [CustomerService]
})
export class CustomersModule {}
