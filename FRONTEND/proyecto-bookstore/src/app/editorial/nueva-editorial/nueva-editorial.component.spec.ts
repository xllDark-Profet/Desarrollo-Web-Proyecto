import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NuevaEditorialComponent } from './nueva-editorial.component';

describe('NuevaEditorialComponent', () => {
  let component: NuevaEditorialComponent;
  let fixture: ComponentFixture<NuevaEditorialComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NuevaEditorialComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NuevaEditorialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
