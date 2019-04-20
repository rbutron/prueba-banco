import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TarjetasFormComponent } from './tarjetas-form.component';

describe('TarjetasFormComponent', () => {
  let component: TarjetasFormComponent;
  let fixture: ComponentFixture<TarjetasFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TarjetasFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TarjetasFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
