import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { map } from 'rxjs/operators';
import { IPlayer } from './player';
import { PLAYLIST } from './mock-player';
@Injectable({
  providedIn: 'root'
})
export class YoutubeService {

  constructor() { }


  getPlaylist(): Observable<IPlayer[]> {
    return of(PLAYLIST);
  }

  find(playerId: string) {
    return this.getPlaylist().pipe(
      map((playlist: IPlayer[]) => {
        return playlist.find(item => item.id == playerId);
      })
    );
  }
}
