import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcessoPythonListComponent } from './processo-python-list.component';

describe('ProcessoPythonListComponent', () => {
  let component: ProcessoPythonListComponent;
  let fixture: ComponentFixture<ProcessoPythonListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProcessoPythonListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcessoPythonListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
