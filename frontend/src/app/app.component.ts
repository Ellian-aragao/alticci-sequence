import { Component, OnDestroy } from '@angular/core';
import { catchError, Observable, of, Subscription } from 'rxjs';
import { AlticciSequenceService } from './alticci-sequence.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnDestroy {
  readonly bounds = {
    minValue: 0,
    maxValue: 157,
  };

  inputNumber = 0;
  presentationAlticciValue = 0;
  $obs: Subscription[] = [];
  showErrorDisplay = false;
  errorDisplay = '';

  constructor(private service: AlticciSequenceService) {}

  onChangeInputNumber(inputHtml: any) {
    const indexAlticciSequence = inputHtml.target.value;
    const $obs = this.service
      .getSequenceFromIndex(indexAlticciSequence)
      .pipe(catchError((error) => this.errorHandler(error)))
      .subscribe((response) => {
        this.showErrorDisplay = false;
        this.presentationAlticciValue = response.value;
      });
    this.$obs.push($obs);
  }

  errorHandler(erro: any): Observable<never> {
    console.error('Erro: ', erro);
    this.showErrorDisplay = true;
    this.errorDisplay = erro.error;
    return of();
  }

  ngOnDestroy() {
    this.$obs.forEach((obs) => obs.unsubscribe());
  }
}
