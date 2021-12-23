import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RefillingFormComponent } from './refilling-form.component';

describe('RefillingFormComponent', () => {
  let component: RefillingFormComponent;
  let fixture: ComponentFixture<RefillingFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RefillingFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RefillingFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
