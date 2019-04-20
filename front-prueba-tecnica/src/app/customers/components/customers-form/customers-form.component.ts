import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import {
  AbstractControl,
  FormControl,
  FormGroup,
  Validators
} from '@angular/forms';
import { Customers } from 'src/app/core/models/customers';

@Component({
  selector: 'app-customers-form',
  templateUrl: './customers-form.component.html',
  styleUrls: ['./customers-form.component.css']
})
export class CustomersFormComponent implements OnInit {
  id: string;

  form = new FormGroup({
    name: new FormControl('', [Validators.required, Validators.maxLength(50)]),
    address: new FormControl('', [
      Validators.required,
      Validators.maxLength(100)
    ]),
    city: new FormControl('', [Validators.required, Validators.maxLength(30)]),
    phone: new FormControl('', [Validators.required, Validators.maxLength(20)])
  });

  @Input()
  isSaving = false;

  @Input()
  error = '';

  @Input()
  set customer(value) {
    if (!value) {
      return;
    }
    this.id = value.id;
    this.form.reset({
      name: value.nombre,
      address: value.direccion,
      city: value.ciudad,
      phone: value.telefono
    });
  }

  @Output()
  save = new EventEmitter<Customers>();

  @Output()
  update = new EventEmitter<Customers>();

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
        id: this.id
      });
    } else {
      this.save.emit(this.form.value);
    }
  }
}
