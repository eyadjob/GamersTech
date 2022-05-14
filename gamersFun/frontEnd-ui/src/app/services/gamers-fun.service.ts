import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
const httpOptions = {
headers: new HttpHeaders({'content-type':'application/json'})
}

@Injectable({
  providedIn: 'root'
})
export class GamersFunService {

  constructor(private http:HttpClient) { }

  getAboutPage() { return this.http.get('/about')}
}
