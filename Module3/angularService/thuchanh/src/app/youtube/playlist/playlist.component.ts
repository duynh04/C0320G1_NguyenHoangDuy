import { Component, OnInit } from '@angular/core';
import { YoutubeService } from '../youtube.service';
import { IPlayer } from './../player';
import { Observable } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-playlist',
  templateUrl: './playlist.component.html',
  styleUrls: ['./playlist.component.scss']
})
export class PlaylistComponent implements OnInit {

  playlist: Observable<IPlayer[]>;
  selectedId: string;
  ngOnInit() {
    this.playlist = this.route.paramMap.pipe(switchMap(params => {
      this.selectedId = params.get('id');
      return this.youtubeService.getPlaylist();
    }))
  }

  constructor(private youtubeService: YoutubeService,
    private route: ActivatedRoute) { }

}
