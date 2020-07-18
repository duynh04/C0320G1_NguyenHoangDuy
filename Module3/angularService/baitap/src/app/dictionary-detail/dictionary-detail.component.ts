import { Component, OnInit } from '@angular/core';
import { DictionaryService } from '../dictionary.service';
import { IWord } from '../iword';
import { ActivatedRoute, ParamMap } from '@angular/router';
@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.scss']
})
export class DictionaryDetailComponent implements OnInit {

  word: IWord;

  constructor(
    private route: ActivatedRoute,
    private dictionaryService: DictionaryService) { }

  ngOnInit() {
    this.route.paramMap.subscribe((paramMap: ParamMap) => {
      this.word = this.dictionaryService.search(paramMap.get('key'));  
    })
  }

}
