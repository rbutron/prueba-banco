import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import {
  FormGroup,
  FormControl,
  Validators,
  AbstractControl
} from '@angular/forms';

@Component({
  selector: 'app-tarjetas-form',
  templateUrl: './tarjetas-form.component.html',
  styleUrls: ['./tarjetas-form.component.css']
})
export class TarjetasFormComponent implements OnInit {
  id: string;
  idUsuario: string;

  form = new FormGroup({
    numTarjeta: new FormControl('', [
      Validators.required,
      Validators.minLength(16),
      Validators.maxLength(16)
    ]),
    ccv: new FormControl('', [
      Validators.required,
      Validators.minLength(3),
      Validators.maxLength(4)
    ]),
    tipoTarjeta: new FormControl('', [Validators.required])
  });

  @Input()
  isSaving = false;

  @Input()
  error = '';

  @Input()
  set tarjeta(valor) {
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
