import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PassoProcessoEditComponent } from './passo-processo-edit.component';

describe('PassoProcessoEditComponent', () => {
  let component: PassoProcessoEditComponent;
  let fixture: ComponentFixture<PassoProcessoEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PassoProcessoEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PassoProcessoEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
