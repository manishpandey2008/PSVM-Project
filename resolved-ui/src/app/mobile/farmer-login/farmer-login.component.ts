import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-farmer-login',
  templateUrl: './farmer-login.component.html',
  styleUrls: ['./farmer-login.component.css']
})
export class FarmerLoginComponent implements OnInit {

  inputFormate="password"
  viewPasswod=true


  constructor() { }

  ngOnInit(): void {

  }


  changeFormate(){
    console.log(this.viewPasswod)
    if(this.viewPasswod){this.viewPasswod=false;this.inputFormate="text"}
    else{this.viewPasswod=true;this.inputFormate="password"}
  }

}
