import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NuevoBookComponent } from './nuevo-book.component';

describe('NuevoBookComponent', () => {
  let component: NuevoBookComponent;
  let fixture: ComponentFixture<NuevoBookComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NuevoBookComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NuevoBookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
