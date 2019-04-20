import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AsesoresFormComponent } from './asesores-form.component';

describe('AsesoresFormComponent', () => {
  let component: AsesoresFormComponent;
  let fixture: ComponentFixture<AsesoresFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AsesoresFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AsesoresFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
