import React from "react";
import "./Movie.css";

function Movie() {
  return (
    <div>
      <MoviePoster />
      <h1>hello this is a movie</h1>
    </div>
  );
}

function MoviePoster() {
  return <img src="https://img.hankyung.com/photo/201904/03.19271312.1.jpg" />;
}

export default Movie;
