import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LinuxInternetEditComponent } from './linux-internet-edit.component';

describe('LinuxInternetEditComponent', () => {
  let component: LinuxInternetEditComponent;
  let fixture: ComponentFixture<LinuxInternetEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LinuxInternetEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LinuxInternetEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
