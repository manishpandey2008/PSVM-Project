import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { FarmerLoginComponent } from "./farmer-login/farmer-login.component";
import { MobileCompComponent } from "./mobile-comp/mobile-comp.component";

const routes:Routes=[
  {component:FarmerLoginComponent,path:""},
  {component:MobileCompComponent,path:"comp"}
]

@NgModule({
  imports:[RouterModule.forChild(routes)],
  exports:[RouterModule]
})
export class MobileRoutingModule{}
