import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-movimientos-table',
  templateUrl: './movimientos-table.component.html',
  styleUrls: ['./movimientos-table.component.css']
})
export class MovimientosTableComponent implements OnInit {
  @Input()
  movimientos = [];

  @Output()
  edit = new EventEmitter();

  @Output()
  delete = new EventEmitter();

  constructor() {}

  ngOnInit() {}

  editMovimiento(movimiento) {
    this.edit.emit(movimiento);
  }

  deleteMovimiento(movimiento) {
    this.delete.emit(movimiento.id);
  }
}
