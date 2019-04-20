import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AsesoresTableComponent } from './asesores-table.component';

describe('AsesoresTableComponent', () => {
  let component: AsesoresTableComponent;
  let fixture: ComponentFixture<AsesoresTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AsesoresTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AsesoresTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
