import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { YoutubeRoutingModule } from './youtube-routing.module';
import { PlaylistComponent } from './playlist/playlist.component';
import { PlayerComponent } from './player/player.component';


@NgModule({
  declarations: [
    PlaylistComponent,
    PlayerComponent
  ],
  imports: [
    CommonModule,
    YoutubeRoutingModule
  ]
})
export class YoutubeModule { }
