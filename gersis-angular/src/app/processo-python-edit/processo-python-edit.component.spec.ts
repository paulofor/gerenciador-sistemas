import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcessoPythonEditComponent } from './processo-python-edit.component';

describe('ProcessoPythonEditComponent', () => {
  let component: ProcessoPythonEditComponent;
  let fixture: ComponentFixture<ProcessoPythonEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProcessoPythonEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcessoPythonEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
