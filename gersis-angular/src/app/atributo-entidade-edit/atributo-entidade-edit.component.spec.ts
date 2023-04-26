import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AtributoEntidadeEditComponent } from './atributo-entidade-edit.component';

describe('AtributoEntidadeEditComponent', () => {
  let component: AtributoEntidadeEditComponent;
  let fixture: ComponentFixture<AtributoEntidadeEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AtributoEntidadeEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AtributoEntidadeEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
