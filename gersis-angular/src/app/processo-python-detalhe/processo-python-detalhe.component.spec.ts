import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcessoPythonDetalheComponent } from './processo-python-detalhe.component';

describe('ProcessoPythonDetalheComponent', () => {
  let component: ProcessoPythonDetalheComponent;
  let fixture: ComponentFixture<ProcessoPythonDetalheComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProcessoPythonDetalheComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcessoPythonDetalheComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
