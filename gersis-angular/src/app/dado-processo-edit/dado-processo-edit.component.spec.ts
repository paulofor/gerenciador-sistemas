import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DadoProcessoEditComponent } from './dado-processo-edit.component';

describe('DadoProcessoEditComponent', () => {
  let component: DadoProcessoEditComponent;
  let fixture: ComponentFixture<DadoProcessoEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DadoProcessoEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DadoProcessoEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
