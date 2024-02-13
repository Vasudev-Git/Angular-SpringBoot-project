import { Component } from '@angular/core';
import { Movie } from '../movie.model'
import { MovieService } from '../movie.service'
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router'

@Component({
  selector: 'app-movie-list',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './movie-list.component.html',
  styleUrl: './movie-list.component.scss'
})
export class MovieListComponent {
  movies: Movie[] = [];

  constructor(private movieService: MovieService) { 
    this.movieService.getAllMovies().subscribe(movies => {
      this.movies = movies;
    });
   }


  
}