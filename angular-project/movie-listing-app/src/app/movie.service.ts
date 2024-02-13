import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Movie } from './movie.model'
import { environment } from '../environments/environment';



@Injectable()
export class MovieService {
  
  private baseUrl = environment.baseUrl;
  private allMoviesPath = '/all-movies';

  constructor(private http: HttpClient) { }

  // Method to fetch all movies
  getAllMovies(): Observable<Movie[]> {
    return this.http.get<Movie[]>(this.baseUrl + this.allMoviesPath);
  }

  
}
