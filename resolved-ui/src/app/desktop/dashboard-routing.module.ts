import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { DashboardHomeComponent } from "./dashboard-home/dashboard-home.component";
import { DaskCompoComponent } from "./dask-compo/dask-compo.component";

const routes: Routes=[
  {path:"",component:DashboardHomeComponent},
  {path:"comp",component:DaskCompoComponent}
]

@NgModule({
  imports:[RouterModule.forChild(routes)],
  exports:[RouterModule]
})
export class DashboardRoutingModule{}
