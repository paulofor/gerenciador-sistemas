import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcessoJavaListComponent } from './processo-java-list.component';

describe('ProcessoJavaListComponent', () => {
  let component: ProcessoJavaListComponent;
  let fixture: ComponentFixture<ProcessoJavaListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProcessoJavaListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcessoJavaListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
