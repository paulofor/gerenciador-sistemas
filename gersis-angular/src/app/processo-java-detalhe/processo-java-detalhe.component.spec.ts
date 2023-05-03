import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcessoJavaDetalheComponent } from './processo-java-detalhe.component';

describe('ProcessoJavaDetalheComponent', () => {
  let component: ProcessoJavaDetalheComponent;
  let fixture: ComponentFixture<ProcessoJavaDetalheComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProcessoJavaDetalheComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcessoJavaDetalheComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
