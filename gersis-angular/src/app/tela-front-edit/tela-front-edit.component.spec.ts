import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TelaFrontEditComponent } from './tela-front-edit.component';

describe('TelaFrontEditComponent', () => {
  let component: TelaFrontEditComponent;
  let fixture: ComponentFixture<TelaFrontEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TelaFrontEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TelaFrontEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
