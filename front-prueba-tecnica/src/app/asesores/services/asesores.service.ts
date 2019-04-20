import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Asesores } from 'src/app/core/models/asesores';
import { environment } from 'src/environments/environment';

@Injectable()
export class AsesoresService {
  private apiUrl = `${environment.apiUrl}/asesor`;

  constructor(private httpClient: HttpClient) {}

  loadAsesores(): Observable<Asesores[]> {
    return this.httpClient.get<Asesores[]>(`${this.apiUrl}/consult`);
  }

  saveAsesor(asesor: Asesores): Observable<Asesores> {
    return this.httpClient.post<Asesores>(`${this.apiUrl}/create`, asesor);
  }

  updateAsesor(asesor: Asesores): Observable<Asesores> {
    return this.httpClient.put<Asesores>(`${this.apiUrl}/update`, asesor);
  }

  deleteAsesor(id: string): Observable<void> {
    return this.httpClient.delete<void>(`${this.apiUrl}/delete/${id}`);
  }
}
