import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ParametroMetodoServerEditComponent } from './parametro-metodo-server-edit.component';

describe('ParametroMetodoServerEditComponent', () => {
  let component: ParametroMetodoServerEditComponent;
  let fixture: ComponentFixture<ParametroMetodoServerEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ParametroMetodoServerEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ParametroMetodoServerEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
