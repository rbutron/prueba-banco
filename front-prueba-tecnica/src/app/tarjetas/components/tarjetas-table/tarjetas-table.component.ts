import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-tarjetas-table',
  templateUrl: './tarjetas-table.component.html',
  styleUrls: ['./tarjetas-table.component.css']
})
export class TarjetasTableComponent implements OnInit {
  @Input()
  tarjetas = [];

  @Output()
  edit = new EventEmitter();

  @Output()
  delete = new EventEmitter();

  constructor() {}

  ngOnInit() {}

  editTarjeta(tarjeta) {
    this.edit.emit(tarjeta);
  }

  deleteTarjeta(tarjeta) {
    this.delete.emit(tarjeta.id);
  }
}
