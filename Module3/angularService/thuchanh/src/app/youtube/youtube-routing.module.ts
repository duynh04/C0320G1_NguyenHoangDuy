import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PlaylistComponent } from './playlist/playlist.component';
import { PlayerComponent } from './player/player.component';
import { Key } from 'protractor';


const routes: Routes = [
  { path: 'playlist', redirectTo: '/youtube' },
  { path: 'player/:id', redirectTo: '/youtube/:id' },
  {
    path: '', component: PlaylistComponent,
    children: [
      { path: '', component: PlayerComponent },
      { path: ':id', component: PlayerComponent }
    ]
  },
  // { path: ':id', component: PlayerComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class YoutubeRoutingModule { }
