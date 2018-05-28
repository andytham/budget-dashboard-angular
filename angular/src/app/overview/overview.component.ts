import { Component, OnInit } from '@angular/core';
import { Event } from '../event';
import { EventService } from '../event.service';

@Component({
  selector: 'app-overview',
  templateUrl: './overview.component.html',
  styleUrls: ['./overview.component.css']
})

export class OverviewComponent implements OnInit {
  events: Event[];
  constructor(private eventService: EventService) {}

  ngOnInit() {
    console.log("testing")
    this.getEvents();
  }
  getEvents(): void {
    this.eventService.getEvents()
    .subscribe(events => this.events = events);
  }
  // constructor() { console.log("hello")}
  //
  // ngOnInit() {
  // }
}
