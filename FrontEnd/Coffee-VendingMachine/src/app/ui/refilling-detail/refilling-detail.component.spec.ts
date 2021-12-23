import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RefillingDetailComponent } from './refilling-detail.component';

describe('RefillingDetailComponent', () => {
  let component: RefillingDetailComponent;
  let fixture: ComponentFixture<RefillingDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RefillingDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RefillingDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
