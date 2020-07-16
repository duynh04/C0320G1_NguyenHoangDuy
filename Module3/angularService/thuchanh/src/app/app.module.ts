import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LifetimeComponent } from './lifetime/lifetime.component';
// import { PlaylistComponent } from './youtube/playlist/playlist.component';
// import { PlayerComponent } from './youtube/player/player.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { YoutubeModule } from './youtube/youtube.module';

@NgModule({
  declarations: [
    AppComponent,
    LifetimeComponent,
    // PlaylistComponent,
    // PlayerComponent,
    PageNotFoundComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    YoutubeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
