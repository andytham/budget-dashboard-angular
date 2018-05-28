import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Event } from './event';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

@Injectable({ providedIn: 'root' })
export class EventService {
  constructor(private http: HttpClient) { }

  // private handleError<T> (operation = 'operation', result?: T) {
  //   return (error: any): Observable<T> => {
  //     // TODO: send the error to remote logging infrastructure
  //     console.error(error); // log to console instead
  //
  //     // TODO: better job of transforming error for user consumption
  //     this.log(`${operation} failed: ${error.message}`);
  //
  //     // Let the app keep running by returning an empty result.
  //     return of(result as T);
  //   };
  // }
  private eventsUrl = 'http://localhost:8080/budgets';
  getEvents (): Observable<Event[]> {
    return this.http.get<Event[]>(this.eventsUrl)
      // .pipe(
      //   tap(events => this.log(`fetched events`)),
      //   catchError(this.handleError('getEvents', []))
      // );
  }
}
