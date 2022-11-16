import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarEditorialComponent } from './editar-editorial.component';

describe('EditarEditorialComponent', () => {
  let component: EditarEditorialComponent;
  let fixture: ComponentFixture<EditarEditorialComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditarEditorialComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditarEditorialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
