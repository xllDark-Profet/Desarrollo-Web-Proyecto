import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrudTableBookComponent } from './crud-table-book.component';

describe('CrudTableBookComponent', () => {
  let component: CrudTableBookComponent;
  let fixture: ComponentFixture<CrudTableBookComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CrudTableBookComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CrudTableBookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
