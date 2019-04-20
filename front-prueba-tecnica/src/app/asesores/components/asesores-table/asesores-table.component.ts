import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';
import { Asesores } from 'src/app/core/models/asesores';

@Component({
  selector: 'app-asesores-table',
  templateUrl: './asesores-table.component.html',
  styleUrls: ['./asesores-table.component.css']
})
export class AsesoresTableComponent implements OnInit {
  @Input()
  asesores: Asesores[] = [];

  asesor: Asesores;

  @Output()
  delete = new EventEmitter<string>();

  constructor() {}

  ngOnInit() {}

  elimiar(id: string): void {
    this.delete.emit(id);
  }
}
