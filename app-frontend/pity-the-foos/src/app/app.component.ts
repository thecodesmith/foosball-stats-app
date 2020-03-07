import { Component } from '@angular/core';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'pity-the-foos';
  links = [
    { title: 'Players', fragment: 'players' },
    { title: 'Scores', fragment: 'scores' },
    { title: 'Games', fragment: 'games' }
  ];


  constructor(public route: ActivatedRoute) {}


}
