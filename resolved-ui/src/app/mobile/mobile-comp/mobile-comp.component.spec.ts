import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MobileCompComponent } from './mobile-comp.component';

describe('MobileCompComponent', () => {
  let component: MobileCompComponent;
  let fixture: ComponentFixture<MobileCompComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MobileCompComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MobileCompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
