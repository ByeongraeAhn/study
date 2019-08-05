import React, { Component } from "react";
import "./Movie.css";

class Movie extends Component {
  render() {
    console.log(this.props);
    return (
      <div>
        <MoviePoster />
        <h1>hello this is a movie</h1>
      </div>
    );
  }
}

class MoviePoster extends Component {
  render() {
    return (
      <img src="https://img.hankyung.com/photo/201904/03.19271312.1.jpg" />
    );
  }
}

export default Movie;
