import { Component,OnInit } from '@angular/core';
import { Router } from '@angular/router';

declare var $:any;
declare var is:any;
@Component({
  selector: 'offsidebar',
  templateUrl: 'offsidebar.component.html'
})
export class OffsidebarComponent implements OnInit{

  private menus = [];
  selectMenuId:number = 0;

  constructor(private router:Router) {
  }

  ngOnInit() {
    this.menus = [
      {
        id:'0',
        name:'列表1',
        url:'#',
        childMenus:[
          {
            id:'10',
            name:'列表1-1',
            url:'#',
          }
        ]
      },
      {
        id:'1',
        name:'列表2',
        url:'#',
        childMenus:[
          {
            id:'20',
            name:'列表2-1',
            url:'#',
          }
        ]
      }
    ]
  }
}

