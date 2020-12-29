import { Component, OnInit } from '@angular/core';
import {NavService} from '../services/nav.service';
import {MatSidenavModule} from '@angular/material/sidenav';


@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  constructor() { }
  ngOnInit(): void {
  }

}
