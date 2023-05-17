import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EscolheEntidadeSaidaParaProcessoComponent } from './escolhe-entidade-saida-para-processo.component';

describe('EscolheEntidadeSaidaParaProcessoComponent', () => {
  let component: EscolheEntidadeSaidaParaProcessoComponent;
  let fixture: ComponentFixture<EscolheEntidadeSaidaParaProcessoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EscolheEntidadeSaidaParaProcessoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EscolheEntidadeSaidaParaProcessoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
