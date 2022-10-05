import { Component, OnDestroy } from '@angular/core';
import { Observable, Subscription } from 'rxjs';
import { AlticciSequenceService } from './alticci-sequence.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnDestroy {
  title = 'alticci-sequence';
  inputNumber = 0;
  presentationAlticciValue = 0;
  $obs: Subscription[] = [];

  constructor(private service: AlticciSequenceService) {}

  onChangeInputNumber(inputHtml: any) {
    const indexAlticciSequence = inputHtml.target.value;
    const $obs = this.service
      .getSequenceFromIndex(indexAlticciSequence)
      .subscribe((response) => {
        this.presentationAlticciValue = response.value;
      });
    this.$obs.push($obs);
  }

  ngOnDestroy() {
    this.$obs.forEach((obs) => obs.unsubscribe());
  }
}
