import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AiApiCallService {

  private apiUrl = 'http://localhost:8083/chatcofrade/ai/cofrade';

  constructor(private http: HttpClient) { }

  sendMessage(message: string): Observable<string> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post<string>(this.apiUrl, message, { 
      headers: headers,
      responseType: 'text' as 'json'
    });
  }
}
