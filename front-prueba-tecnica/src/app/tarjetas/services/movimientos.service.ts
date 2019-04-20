import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable()
export class MovimientosService {
  private apiUrl = `${environment.apiUrl}/movimiento`;

  constructor(private httpClient: HttpClient) {}

  loadMovimientos(idTarjeta: string): Observable<any[]> {
    return this.httpClient
      .get<any[]>(`${this.apiUrl}/consult`)
      .pipe(
        map(movimientos =>
          movimientos.filter(movimiento => movimiento.idUsuario === idTarjeta)
        )
      );
  }

  createMovimiento(movimiento): Observable<any> {
    return this.httpClient.post<any>(`${this.apiUrl}/create`, movimiento);
  }

  updateMovimiento(movimiento): Observable<any> {
    return this.httpClient.put<any>(`${this.apiUrl}/update`, movimiento);
  }

  deleteMovimiento(id: string): Observable<void> {
    return this.httpClient.delete<void>(`${this.apiUrl}/delete/${id}`);
  }
}
