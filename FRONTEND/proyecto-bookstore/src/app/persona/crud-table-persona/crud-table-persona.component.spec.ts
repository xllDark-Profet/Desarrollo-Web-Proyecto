import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrudTablePersonaComponent } from './crud-table-persona.component';

describe('CrudTablePersonaComponent', () => {
  let component: CrudTablePersonaComponent;
  let fixture: ComponentFixture<CrudTablePersonaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CrudTablePersonaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CrudTablePersonaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
