import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrudTableEditorialComponent } from './crud-table-editorial.component';

describe('CrudTableEditorialComponent', () => {
  let component: CrudTableEditorialComponent;
  let fixture: ComponentFixture<CrudTableEditorialComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CrudTableEditorialComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CrudTableEditorialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
