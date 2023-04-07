import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProdutoHotmartListComponent } from './produto-hotmart-list.component';

describe('ProdutoHotmartListComponent', () => {
  let component: ProdutoHotmartListComponent;
  let fixture: ComponentFixture<ProdutoHotmartListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProdutoHotmartListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProdutoHotmartListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
