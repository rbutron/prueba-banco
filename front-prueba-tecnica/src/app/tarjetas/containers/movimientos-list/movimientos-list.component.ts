import { Component, OnInit } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { MovimientosService } from '../../services/movimientos.service';
import { tap } from 'rxjs/operators';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-movimientos-list',
  templateUrl: './movimientos-list.component.html',
  styleUrls: ['./movimientos-list.component.css']
})
export class MovimientosListComponent implements OnInit {
  showForm = false;
  movimientos$ = new BehaviorSubject([]);
  isLoading$ = new BehaviorSubject(false);
  isSaving$ = new BehaviorSubject(false);
  editingMovimiento = null;
  idTarjeta: string;

  constructor(
    private movimientoService: MovimientosService,
    route: ActivatedRoute
  ) {
    this.idTarjeta = route.snapshot.params.idTarjeta;
  }

  ngOnInit() {
    this.loadMovimientos();
  }

  toggleForm(): void {
    this.showForm = !this.showForm;
  }

  loadMovimientos(): void {
    this.isLoading$.next(true);
    this.movimientoService
      .loadMovimientos(this.idTarjeta)
      .pipe(
        tap(movimientos => {
          this.movimientos$.next(movimientos);
          this.isLoading$.next(false);
          this.showForm = false;
        })
      )
      .subscribe();
  }

  saveMovimiento(movimiento): void {
    this.isSaving$.next(true);
    this.movimientoService
      .createMovimiento({ ...movimiento, idUsuario: this.idTarjeta })
      .pipe(
        tap(() => {
          this.isSaving$.next(false);
          this.loadMovimientos();
        })
      )
      .subscribe();
  }

  updateMovimiento(movimiento): void {
    this.movimientoService
      .updateMovimiento(movimiento)
      .pipe(
        tap(() => {
          this.loadMovimientos();
          this.showForm = false;
          this.editingMovimiento = null;
        })
      )
      .subscribe();
  }

  deleteMovimiento(id: string): void {
    this.movimientoService
      .deleteMovimiento(id)
      .pipe(
        tap(() => {
          this.loadMovimientos();
        })
      )
      .subscribe();
  }

  editMovimiento(movimiento): void {
    this.editingMovimiento = movimiento;
    this.showForm = true;
  }
}
