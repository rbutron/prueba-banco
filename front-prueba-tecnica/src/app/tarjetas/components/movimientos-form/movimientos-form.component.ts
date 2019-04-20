import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import {
  FormGroup,
  FormControl,
  Validators,
  AbstractControl
} from '@angular/forms';

@Component({
  selector: 'app-movimientos-form',
  templateUrl: './movimientos-form.component.html',
  styleUrls: ['./movimientos-form.component.css']
})
export class MovimientosFormComponent implements OnInit {
  id: string;
  idUsuario: string;

  form = new FormGroup({
    fechaConsumo: new FormControl('', [Validators.required]),
    descripcion: new FormControl('', [Validators.required]),
    monto: new FormControl(0, [Validators.required, Validators.min(0)])
  });

  @Input()
  isSaving = false;

  @Input()
  error = '';

  @Input()
  set movimiento(valor) {
    if (!valor) {
      return;
    }
    this.id = valor.id;
    this.idUsuario = valor.idUsuario;
    this.form.reset(valor);
  }

  @Output()
  save = new EventEmitter();

  @Output()
  update = new EventEmitter();

  constructor() {}

  ngOnInit() {}

  touchField(control: AbstractControl): void {
    control.markAsDirty();
    control.updateValueAndValidity();
  }

  submitForm(): void {
    if (this.id) {
      this.update.emit({
        ...this.form.value,
        id: this.id,
        idUsuario: this.idUsuario
      });
    } else {
      this.save.emit(this.form.value);
    }
  }
}
