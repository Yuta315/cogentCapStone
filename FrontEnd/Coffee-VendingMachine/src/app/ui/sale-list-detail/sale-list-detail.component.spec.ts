import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SaleListDetailComponent } from './sale-list-detail.component';

describe('SaleListDetailComponent', () => {
  let component: SaleListDetailComponent;
  let fixture: ComponentFixture<SaleListDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SaleListDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SaleListDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
