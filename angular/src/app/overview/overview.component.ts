import { Component, OnInit } from '@angular/core';
import { EVENTS } from '../dummy-data';
import { Event } from '../event';


@Component({
  selector: 'app-overview',
  templateUrl: './overview.component.html',
  styleUrls: ['./overview.component.css']
})

export class OverviewComponent implements OnInit {
  events = EVENTS;

  constructor() { }

  ngOnInit() {
  }
  getEvents(): void {
    
  }
}
