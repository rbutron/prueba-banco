import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable, forkJoin } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable()
export class TarjetasService {
  private apiUrl = `${environment.apiUrl}/tarjeta`;

  constructor(private httpClient: HttpClient) {}

  loadTarjetas(customerId: string): Observable<any[]> {
    const tarjetas = this.httpClient
      .get<any[]>(`${this.apiUrl}/consult`)
      .pipe(
        map(tarjetas =>
          tarjetas.filter(tarjeta => tarjeta.idUsuario === customerId)
        )
      );

    return forkJoin(tarjetas, this.loadMovimientos()).pipe(
      map(([tarjetas, movimientos]) =>
        tarjetas.map(tarjeta => ({
          ...tarjeta,
          movimientos: movimientos.filter(
            movimiento => movimiento.idUsuario === tarjeta.id
          ).length
        }))
      )
    );
  }

  saveTarjeta(tarjeta): Observable<any> {
    return this.httpClient.post(`${this.apiUrl}/create`, tarjeta);
  }

  deleteTarjeta(id: string): Observable<void> {
    return this.httpClient.delete<void>(`${this.apiUrl}/delete/${id}`);
  }

  updateTarjeta(tarjeta): Observable<any> {
    return this.httpClient.put<any>(`${this.apiUrl}/update`, tarjeta);
  }

  loadMovimientos(): Observable<any[]> {
    return this.httpClient.get<any[]>(
      `${environment.apiUrl}/movimiento/consult`
    );
  }
}
