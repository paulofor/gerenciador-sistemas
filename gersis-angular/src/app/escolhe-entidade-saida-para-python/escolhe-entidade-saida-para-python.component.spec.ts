import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EscolheEntidadeSaidaParaPythonComponent } from './escolhe-entidade-saida-para-python.component';

describe('EscolheEntidadeSaidaParaPythonComponent', () => {
  let component: EscolheEntidadeSaidaParaPythonComponent;
  let fixture: ComponentFixture<EscolheEntidadeSaidaParaPythonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EscolheEntidadeSaidaParaPythonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EscolheEntidadeSaidaParaPythonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
