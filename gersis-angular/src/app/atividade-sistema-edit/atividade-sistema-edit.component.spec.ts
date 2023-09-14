import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AtividadeSistemaEditComponent } from './atividade-sistema-edit.component';

describe('AtividadeSistemaEditComponent', () => {
  let component: AtividadeSistemaEditComponent;
  let fixture: ComponentFixture<AtividadeSistemaEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AtividadeSistemaEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AtividadeSistemaEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
