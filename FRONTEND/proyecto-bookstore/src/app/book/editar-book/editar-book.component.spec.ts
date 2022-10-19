import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarBookComponent } from './editar-book.component';

describe('EditarBookComponent', () => {
  let component: EditarBookComponent;
  let fixture: ComponentFixture<EditarBookComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditarBookComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditarBookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
