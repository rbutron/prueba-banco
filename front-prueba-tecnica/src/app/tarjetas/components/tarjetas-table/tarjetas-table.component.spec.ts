import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TarjetasTableComponent } from './tarjetas-table.component';

describe('TarjetasTableComponent', () => {
  let component: TarjetasTableComponent;
  let fixture: ComponentFixture<TarjetasTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TarjetasTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TarjetasTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
