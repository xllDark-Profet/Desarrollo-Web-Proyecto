import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaBookComponent } from './lista-book.component';

describe('ListaBookComponent', () => {
  let component: ListaBookComponent;
  let fixture: ComponentFixture<ListaBookComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaBookComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListaBookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
