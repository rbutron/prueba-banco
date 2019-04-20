import { Component, OnInit, EventEmitter, Output, Input } from '@angular/core';
import { Customers } from 'src/app/core/models/customers';

@Component({
  selector: 'app-customers-table',
  templateUrl: './customers-table.component.html',
  styleUrls: ['./customers-table.component.css']
})
export class CustomersTableComponent implements OnInit {
  @Input()
  customers: Customers[] = [];

  @Output()
  delete = new EventEmitter<string>();

  @Output()
  edit = new EventEmitter<Customers>();

  constructor() {}

  ngOnInit() {}

  deleteCustomer(customer): void {
    this.delete.emit(customer.id);
  }

  editCustomer(customer): void {
    this.edit.emit(customer);
  }
}
