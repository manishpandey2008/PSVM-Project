import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-mobile-home',
  templateUrl: './mobile-home.component.html',
  styleUrls: ['./mobile-home.component.css']
})
export class MobileHomeComponent implements OnInit {


  toggle=false
  items=[1,2,3,4,5,6]
  pinCode={header:"Youe current location",chageButtonUrl:"/",chageButtonText:"Change",headerColor:"bg-gray-300",textAlingment:"text-center"}
  govtYojna={header:"श्रम योजना",chageButtonUrl:"none",chageButtonText:"",headerColor:"bg-gray-300",textAlingment:"text-left"}
  workUpdate={header:"Current work status",chageButtonUrl:"none",chageButtonText:"",headerColor:"bg-gray-300",textAlingment:"text-center"}

  constructor() { }

  ngOnInit(): void {
  }
  toggleResponse(result:any){
    this.toggle=result;
  }

}
