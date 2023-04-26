import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LinuxInternetListComponent } from './linux-internet-list.component';

describe('LinuxInternetListComponent', () => {
  let component: LinuxInternetListComponent;
  let fixture: ComponentFixture<LinuxInternetListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LinuxInternetListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LinuxInternetListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
