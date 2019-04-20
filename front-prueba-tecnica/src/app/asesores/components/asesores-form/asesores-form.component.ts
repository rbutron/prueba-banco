import { Component, OnInit, EventEmitter, Output, Input } from '@angular/core';
import {
  AbstractControl,
  FormControl,
  FormGroup,
  Validators
} from '@angular/forms';
import { Asesores } from 'src/app/core/models/asesores';

@Component({
  selector: 'app-asesores-form',
  templateUrl: './asesores-form.component.html',
  styleUrls: ['./asesores-form.component.css']
})
export class AsesoresFormComponent implements OnInit {
  asesor: Asesores;
  id: string;
  form = new FormGroup({
    nombre: new FormControl('', [
      Validators.required,
      Validators.maxLength(50)
    ]),
    especialidad: new FormControl('', [
      Validators.required,
      Validators.maxLength(50)
    ])
  });

  @Input()
  isSaving = false;

  @Input()
  set updateAsesor(asesor: Asesores) {
    if (asesor !== null && asesor !== undefined) {
      this.id = asesor.id;
      this.form = new FormGroup({
        nombre: new FormControl(asesor.nombre, [
          Validators.required,
          Validators.maxLength(50)
        ]),
        especialidad: new FormControl(asesor.especialidad, [
          Validators.required,
          Validators.maxLength(50)
        ])
      });
    }
  }

  @Output()
  save = new EventEmitter<Asesores>();

  constructor() {}

  ngOnInit() {}

  touchField(control: AbstractControl): void {
    control.markAsDirty();
    control.updateValueAndValidity();
  }

  submitForm(): void {
    this.save.emit({ ...this.form.value, id: this.id });
  }
}
