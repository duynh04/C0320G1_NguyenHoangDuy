import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { YoutubeService } from '../youtube.service';
import { IPlayer } from './../player';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';

@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.scss']
})
export class PlayerComponent implements OnInit {
  src: SafeResourceUrl;
  player$: Observable<IPlayer>;
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private service: YoutubeService,
    private domSanitizer: DomSanitizer
  ) { }
  ngOnInit() {
    this.player$ = this.route.paramMap.pipe(switchMap(
      (param: ParamMap) => {
        console.log('xinchao: ' + param.get('id'));
        return this.service.find(param.get('id'));
      })
    );
  }
  getSrc() {
    this.player$.subscribe(player => {
      const url = 'https://www.youtube.com/embed/' + player.id;
      console.log(player.song);
      this.src = this.domSanitizer.bypassSecurityTrustResourceUrl(url);
    });
    return this.src;
  }
}
