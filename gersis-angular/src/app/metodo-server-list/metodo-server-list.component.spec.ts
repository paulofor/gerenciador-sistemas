import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MetodoServerListComponent } from './metodo-server-list.component';

describe('MetodoServerListComponent', () => {
  let component: MetodoServerListComponent;
  let fixture: ComponentFixture<MetodoServerListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MetodoServerListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MetodoServerListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
