import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MetodoServerEditComponent } from './metodo-server-edit.component';

describe('MetodoServerEditComponent', () => {
  let component: MetodoServerEditComponent;
  let fixture: ComponentFixture<MetodoServerEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MetodoServerEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MetodoServerEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
