import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DadoProcessoEntradaEditComponent } from './dado-processo-entrada-edit.component';

describe('DadoProcessoEntradaEditComponent', () => {
  let component: DadoProcessoEntradaEditComponent;
  let fixture: ComponentFixture<DadoProcessoEntradaEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DadoProcessoEntradaEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DadoProcessoEntradaEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
