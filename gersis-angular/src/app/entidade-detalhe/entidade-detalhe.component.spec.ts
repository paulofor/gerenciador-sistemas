import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EntidadeDetalheComponent } from './entidade-detalhe.component';

describe('EntidadeDetalheComponent', () => {
  let component: EntidadeDetalheComponent;
  let fixture: ComponentFixture<EntidadeDetalheComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EntidadeDetalheComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EntidadeDetalheComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
