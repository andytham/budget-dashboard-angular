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
  refresh(): void {
    window.location.reload();
  }
  add(name: string,funds: number,date: string): void {
    name = name.trim();
    if (!name) { return; }
    this.eventService.addEvent({  name: name , funds: funds, date: date } as Event)
      .subscribe(event => {
        this.events.push(event);
    })
    // .subscribe(() => this.refresh());
  }
  save(event): void {
    this.eventService.updateEvent(event)
    .subscribe(() => this.goBack());
  }
  selectedEvent: Event;
  onSelect(event: Event){
    this.selectedEvent = event;
  }

}
