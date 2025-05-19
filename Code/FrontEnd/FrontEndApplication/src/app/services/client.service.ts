import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private http: HttpClient) { }

  getClients() {
    return this.http.get('http://localhost:8080/client');
  }
}
