import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RelacionamentoEntidadeEditComponent } from './relacionamento-entidade-edit.component';

describe('RelacionamentoEntidadeEditComponent', () => {
  let component: RelacionamentoEntidadeEditComponent;
  let fixture: ComponentFixture<RelacionamentoEntidadeEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RelacionamentoEntidadeEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RelacionamentoEntidadeEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
