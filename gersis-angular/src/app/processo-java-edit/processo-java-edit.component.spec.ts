import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcessoJavaEditComponent } from './processo-java-edit.component';

describe('ProcessoJavaEditComponent', () => {
  let component: ProcessoJavaEditComponent;
  let fixture: ComponentFixture<ProcessoJavaEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProcessoJavaEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcessoJavaEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
