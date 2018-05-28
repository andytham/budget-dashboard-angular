import { Component, OnInit } from '@angular/core';
import { EVENTS } from '../dummy-data';
import gains from '../gains';

@Component({
  selector: 'app-gains',
  templateUrl: './gains.component.html',
  styleUrls: ['./gains.component.css']
})
export class GainsComponent implements OnInit {
  events = gains;

  constructor() { }

  ngOnInit() {

  }

}
