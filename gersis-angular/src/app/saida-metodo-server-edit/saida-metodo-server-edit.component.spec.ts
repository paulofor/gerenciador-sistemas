import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SaidaMetodoServerEditComponent } from './saida-metodo-server-edit.component';

describe('SaidaMetodoServerEditComponent', () => {
  let component: SaidaMetodoServerEditComponent;
  let fixture: ComponentFixture<SaidaMetodoServerEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SaidaMetodoServerEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SaidaMetodoServerEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
