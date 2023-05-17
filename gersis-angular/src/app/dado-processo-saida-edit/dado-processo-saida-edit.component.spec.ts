import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DadoProcessoSaidaEditComponent } from './dado-processo-saida-edit.component';

describe('DadoProcessoSaidaEditComponent', () => {
  let component: DadoProcessoSaidaEditComponent;
  let fixture: ComponentFixture<DadoProcessoSaidaEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DadoProcessoSaidaEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DadoProcessoSaidaEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
