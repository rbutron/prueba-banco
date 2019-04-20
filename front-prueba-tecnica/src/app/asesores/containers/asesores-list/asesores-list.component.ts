import { Component, OnInit } from '@angular/core';
import { Asesores } from 'src/app/core/models/asesores';
import { BehaviorSubject, Observable } from 'rxjs';
import { AsesoresService } from '../../services/asesores.service';
import { tap, map } from 'rxjs/operators';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-asesores-list',
  templateUrl: './asesores-list.component.html',
  styleUrls: ['./asesores-list.component.css']
})
export class AsesoresListComponent implements OnInit {
  showForm = false;

  asesor$: any;
  asesores$ = new BehaviorSubject<Asesores[]>([]);
  isLoading$ = new BehaviorSubject(false);
  isSaving$ = new BehaviorSubject(false);

  constructor(
    private asesoresService: AsesoresService,
    private route: ActivatedRoute,
    private router: Router
  ) {
    const id = this.route.snapshot.paramMap.get('id');
    if (id !== null && id !== undefined && id !== '') {
      this.showForm = true;
      this.asesor$ = this.asesores$.pipe(
        map(asesor => asesor.find(a => a.id === id))
      );
    }
  }

  ngOnInit() {
    this.loadAsesores();
  }

  formAddNewCustomer(): void {
    this.router.navigate(['asesores']);
    this.showForm = true;
  }

  loadAsesores(): void {
    this.isLoading$.next(true);
    this.asesoresService
      .loadAsesores()
      .pipe(
        tap(asesores => {
          this.asesores$.next(asesores);
          this.isLoading$.next(false);
        })
      )
      .subscribe();
  }

  save(asesor: Asesores): void {
    this.isSaving$.next(true);
    if (asesor.id !== null && asesor.id !== undefined) {
      this.asesoresService
        .updateAsesor(asesor)
        .pipe(
          tap(() => {
            this.isSaving$.next(false);
            this.showForm = false;
            this.loadAsesores();
          })
        )
        .subscribe();
    } else {
      this.asesoresService
        .saveAsesor(asesor)
        .pipe(
          tap(() => {
            this.isSaving$.next(false);
            this.showForm = false;
            this.loadAsesores();
          })
        )
        .subscribe();
    }
  }

  delete(id: string) {
    console.log('llego ', id);
    this.asesoresService
      .deleteAsesor(id)
      .pipe(
        tap(() => {
          this.isSaving$.next(false);
          this.showForm = false;
          this.loadAsesores();
        })
      )
      .subscribe();
  }
}
