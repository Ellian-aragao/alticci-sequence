import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { AlticciTerm } from "./AlticciTerm.interface";

@Injectable({
  providedIn: 'root',
})
export class AlticciSequenceService {
  private readonly api = environment.apiUrl;

  constructor(private client: HttpClient) {}

  getSequenceFromIndex(index: number): Observable<AlticciTerm> {
    return this.client.get<AlticciTerm>(`${this.api}/alticci/${index}`);
  }
}
