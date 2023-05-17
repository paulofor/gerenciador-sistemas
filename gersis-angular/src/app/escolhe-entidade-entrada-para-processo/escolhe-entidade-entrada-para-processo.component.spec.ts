import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EscolheEntidadeEntradaParaProcessoComponent } from './escolhe-entidade-entrada-para-processo.component';

describe('EscolheEntidadeEntradaParaProcessoComponent', () => {
  let component: EscolheEntidadeEntradaParaProcessoComponent;
  let fixture: ComponentFixture<EscolheEntidadeEntradaParaProcessoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EscolheEntidadeEntradaParaProcessoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EscolheEntidadeEntradaParaProcessoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
