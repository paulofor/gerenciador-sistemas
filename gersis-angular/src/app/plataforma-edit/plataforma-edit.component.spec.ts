import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlataformaEditComponent } from './plataforma-edit.component';

describe('PlataformaEditComponent', () => {
  let component: PlataformaEditComponent;
  let fixture: ComponentFixture<PlataformaEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlataformaEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlataformaEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
