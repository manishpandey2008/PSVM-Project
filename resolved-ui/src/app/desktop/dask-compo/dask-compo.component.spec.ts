import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DaskCompoComponent } from './dask-compo.component';

describe('DaskCompoComponent', () => {
  let component: DaskCompoComponent;
  let fixture: ComponentFixture<DaskCompoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DaskCompoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DaskCompoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
