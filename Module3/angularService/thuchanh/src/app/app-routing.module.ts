import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LifetimeComponent } from './lifetime/lifetime.component';
// import { PlayerComponent } from './youtube/player/player.component';
// import { PlaylistComponent } from './youtube/playlist/playlist.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { YoutubeModule } from './youtube/youtube.module';

const routes: Routes = [
  { path: 'lifetime', component: LifetimeComponent },
  {
    path: 'youtube', loadChildren: () => import('./youtube/youtube.module').then(mod => mod.YoutubeModule)
  },
  { path: '', redirectTo: '/youtube', pathMatch: 'full' },
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
