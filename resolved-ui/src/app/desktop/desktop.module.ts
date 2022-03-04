import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardHomeComponent } from './dashboard-home/dashboard-home.component';
import { DashboardRoutingModule } from './dashboard-routing.module';
import { DaskCompoComponent } from './dask-compo/dask-compo.component';

@NgModule({
  declarations: [
    DashboardHomeComponent,
    DaskCompoComponent
  ],
  exports:[
  ],
  imports: [
    CommonModule,
    DashboardRoutingModule
  ]
})
export class DesktopModule { }
