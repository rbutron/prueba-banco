import { Component, OnInit } from '@angular/core';
import { Customers } from 'src/app/core/models/customers';
import { CustomerService } from '../../services/customer.service';
import { BehaviorSubject, empty } from 'rxjs';
import { tap, catchError } from 'rxjs/operators';

@Component({
  selector: 'app-customers-list',
  templateUrl: './customers-list.component.html',
  styleUrls: ['./customers-list.component.css']
})
export class CustomersListComponent implements OnInit {
  showForm = false;

  customers$ = new BehaviorSubject<Customers[]>([]);
  isLoading$ = new BehaviorSubject(false);
  isSaving$ = new BehaviorSubject(false);
  editingCustomer: Customers;

  saveError = '';

  constructor(private customerService: CustomerService) {}

  ngOnInit() {
    this.loadCustomers();
  }

  toggleForm(): void {
    this.showForm = !this.showForm;
    this.editingCustomer = null;
  }

  loadCustomers(): void {
    this.isLoading$.next(true);
    this.customerService
      .loadCustomer()
      .pipe(
        tap(customers => {
          this.customers$.next(customers);
          this.isLoading$.next(false);
        })
      )
      .subscribe();
  }

  save(customer: Customers): void {
    this.isSaving$.next(true);
    this.customerService
      .createCustomer(customer)
      .pipe(
        tap(() => {
          this.loadCustomers();
          this.isSaving$.next(false);
          this.showForm = false;
        }),
        catchError(({ error }) => {
          this.isSaving$.next(false);
          this.saveError = error.mensaje;
          return empty();
        })
      )
      .subscribe();
  }

  update(customer: Customers): void {
    this.customerService
      .updateCustomer(customer)
      .pipe(
        tap(() => {
          this.showForm = false;
          this.editingCustomer = null;
          this.loadCustomers();
        })
      )
      .subscribe();
  }

  deleteCustomer(customerId: string) {
    this.customerService
      .deleteCustomer(customerId)
      .pipe(
        tap(() => {
          this.loadCustomers();
        })
      )
      .subscribe();
  }

  editCustomer(customer) {
    this.editingCustomer = customer;
    this.showForm = true;
  }
}
