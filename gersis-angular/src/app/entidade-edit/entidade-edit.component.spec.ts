import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EntidadeEditComponent } from './entidade-edit.component';

describe('EntidadeEditComponent', () => {
  let component: EntidadeEditComponent;
  let fixture: ComponentFixture<EntidadeEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EntidadeEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EntidadeEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
