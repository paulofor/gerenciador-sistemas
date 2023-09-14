import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AtividadeSistemaListComponent } from './atividade-sistema-list.component';

describe('AtividadeSistemaListComponent', () => {
  let component: AtividadeSistemaListComponent;
  let fixture: ComponentFixture<AtividadeSistemaListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AtividadeSistemaListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AtividadeSistemaListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
