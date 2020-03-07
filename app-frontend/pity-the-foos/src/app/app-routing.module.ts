import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PlayersComponent} from "./players/players.component";
import {ScoresComponent} from "./scores/scores.component";
import {GamesComponent} from "./games/games.component";
import {PageNotFoundComponent} from "./page-not-found/page-not-found.component";
import {HomeComponent} from "./home/home.component";


const routes: Routes = [
  { path: 'players', component: PlayersComponent },
  { path: 'scores', component: ScoresComponent},
  { path: 'games', component: GamesComponent },
  { path: '', component: HomeComponent },
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
