import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReportOptionComponent } from './report-option.component';

describe('ReportOptionComponent', () => {
  let component: ReportOptionComponent;
  let fixture: ComponentFixture<ReportOptionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReportOptionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReportOptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
