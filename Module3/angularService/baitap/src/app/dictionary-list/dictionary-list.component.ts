import { Component, OnInit } from '@angular/core';
import { DictionaryService } from '../dictionary.service';
import { IWord } from '../iword';

@Component({
  selector: 'app-dictionary-list',
  templateUrl: './dictionary-list.component.html',
  styleUrls: ['./dictionary-list.component.scss']
})
export class DictionaryListComponent implements OnInit {

  dictionaryList: IWord[];
  constructor(private dictionaryService: DictionaryService) { }

  ngOnInit() {
    this.dictionaryList = this.dictionaryService.getAll();
  }

}
