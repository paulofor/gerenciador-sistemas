import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EscolheEntidadeEntradaParaPythonComponent } from './escolhe-entidade-entrada-para-python.component';

describe('EscolheEntidadeEntradaParaPythonComponent', () => {
  let component: EscolheEntidadeEntradaParaPythonComponent;
  let fixture: ComponentFixture<EscolheEntidadeEntradaParaPythonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EscolheEntidadeEntradaParaPythonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EscolheEntidadeEntradaParaPythonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
