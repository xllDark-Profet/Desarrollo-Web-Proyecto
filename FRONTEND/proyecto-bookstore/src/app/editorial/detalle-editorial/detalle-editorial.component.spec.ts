import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalleEditorialComponent } from './detalle-editorial.component';

describe('DetalleEditorialComponent', () => {
  let component: DetalleEditorialComponent;
  let fixture: ComponentFixture<DetalleEditorialComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetalleEditorialComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DetalleEditorialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
