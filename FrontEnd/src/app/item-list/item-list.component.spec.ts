import { ComponentFixture, TestBed } from '@angular/core/testing';

import { itemListComponent } from './item-list.component';

describe('itemListComponent', () => {
  let component: itemListComponent;
  let fixture: ComponentFixture<itemListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ itemListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(itemListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
