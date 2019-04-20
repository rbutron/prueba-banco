import { Component, OnInit } from '@angular/core';
import { TarjetasService } from '../../services/tarjetas.service';
import { BehaviorSubject, empty } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { tap, catchError } from 'rxjs/operators';

@Component({
  selector: 'app-tarjetas-list',
  templateUrl: './tarjetas-list.component.html',
  styleUrls: ['./tarjetas-list.component.css']
})
export class TarjetasListComponent implements OnInit {
  showForm = false;
  tarjetas$ = new BehaviorSubject([]);
  isLoading$ = new BehaviorSubject(false);
  isSaving$ = new BehaviorSubject(false);
  savingError = '';
  editingTarjeta = null;
  idUsuario: string;

  constructor(private tarjetasService: TarjetasService, route: ActivatedRoute) {
    this.idUsuario = route.snapshot.params.id;
  }

  ngOnInit() {
    this.loadTarjetas();
  }

  toggleForm() {
    this.showForm = !this.showForm;
  }

  loadTarjetas(): void {
    this.isLoading$.next(true);
    this.tarjetasService
      .loadTarjetas(this.idUsuario)
      .pipe(
        tap(tarjetas => {
          this.tarjetas$.next(tarjetas);
          this.isLoading$.next(false);
        })
      )
      .subscribe();
  }

  saveTarjeta(tarjeta): void {
    this.isSaving$.next(true);
    this.tarjetasService
      .saveTarjeta({ ...tarjeta, idUsuario: this.idUsuario })
      .pipe(
        tap(() => {
          this.isSaving$.next(false);
          this.loadTarjetas();
          this.showForm = false;
        }),
        catchError(({ error }) => {
          this.savingError = error.mensaje;
          return empty();
        })
      )
      .subscribe();
  }

  editTarjeta(tarjeta): void {
    this.editingTarjeta = tarjeta;
    this.showForm = true;
  }

  deleteTarjeta(id: string): void {
    this.tarjetasService
      .deleteTarjeta(id)
      .pipe(
        tap(() => {
          this.loadTarjetas();
        })
      )
      .subscribe();
  }

  updateTarjeta(tarjeta): void {
    this.tarjetasService
      .updateTarjeta(tarjeta)
      .pipe(
        tap(() => {
          this.loadTarjetas();
          this.showForm = false;
          this.editingTarjeta = null;
        })
      )
      .subscribe();
  }
}
