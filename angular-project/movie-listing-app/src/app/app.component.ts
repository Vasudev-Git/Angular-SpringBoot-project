import { Component } from '@angular/core';
import { MovieListComponent } from './movie-list/movie-list.component';
import { MovieService } from './movie.service'
import { HttpClient, HttpClientModule } from '@angular/common/http'



@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    MovieListComponent, 
    HttpClientModule
  ],
  providers: [
    MovieService, 
    HttpClient
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'movie-listing-app';
}
