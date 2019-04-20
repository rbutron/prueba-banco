import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable, forkJoin } from 'rxjs';
import { Customers, CustomerTarjetas } from 'src/app/core/models/customers';
import { map } from 'rxjs/operators';

@Injectable()
export class CustomerService {
  private apiUrl = `${environment.apiUrl}/user`;

  constructor(private httpClient: HttpClient) {}

  createCustomer(customer: Customers): Observable<any> {
    return this.httpClient.post<any>(`${this.apiUrl}/create`, {
      nombre: customer.name,
      ciudad: customer.city,
      telefono: customer.phone,
      direccion: customer.address
    });
  }

  deleteCustomer(id: string): Observable<any> {
    return this.httpClient.delete<void>(`${this.apiUrl}/delete/${id}`);
  }

  loadCustomer(): Observable<CustomerTarjetas[]> {
    const customers = this.httpClient.get<any[]>(`${this.apiUrl}/consult`);

    return forkJoin(customers, this.loadTarjetas()).pipe(
      map(([customers, tarjetas]) => {
        return customers.map(customer => ({
          ...customer,
          tarjetas: tarjetas.filter(
            tarjeta => tarjeta.idUsuario === customer.id
          ).length
        }));
      })
    );
  }

  loadTarjetas(): Observable<any[]> {
    const apiUrl = `${environment.apiUrl}/tarjeta/consult`;
    return this.httpClient.get<any[]>(apiUrl);
  }

  updateCustomer(customer: Customers): Observable<Customers> {
    return this.httpClient.put<Customers>(`${this.apiUrl}/update`, {
      id: customer.id,
      nombre: customer.name,
      ciudad: customer.city,
      telefono: customer.phone,
      direccion: customer.address
    });
  }
}
