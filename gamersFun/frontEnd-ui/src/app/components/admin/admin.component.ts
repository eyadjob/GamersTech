import { Component, OnInit } from '@angular/core';
import {GamersFunService} from "../../services/gamers-fun.service";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  // public bikes;

  constructor(private gamersFun:GamersFunService ) { }

  ngOnInit(): void {
    this.getAboutPageAdmin()
  }

  getAboutPageAdmin() {
    this.gamersFun.getAboutPage();

  }

  // getBikes() {
  //   this.bikeService.getBikes().subscribe(
  //     data => {this.bikes = data},
  //     err => console.error(err),
  //     () => console.log('bike loaded')
  //   );
  // }

}
