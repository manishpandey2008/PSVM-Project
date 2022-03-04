import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MobileRoutingModule } from './mobile-routing.module';
import { MobileCompComponent } from './mobile-comp/mobile-comp.component';
import { FarmerLoginComponent } from './farmer-login/farmer-login.component';



@NgModule({
  declarations: [
    FarmerLoginComponent,
    MobileCompComponent
  ],
  exports:[

  ],
  imports: [
    CommonModule,
    MobileRoutingModule
  ]
})
export class MobileModule { }
