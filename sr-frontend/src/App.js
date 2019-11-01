import React, { Component } from "react";
import axios from "axios";
import moment from "moment";
import Movie from "./Movie";
import "./App.css";

class App extends Component {
  state = {
    isLoading: true,
    movies: []
  };

  componentDidMount() {
    setInterval(this.hello, 250);
    this.getBoxOfficeList();
  }

  getBoxOfficeList = async () => {
    const everyMonday = moment()
      .startOf("isoweek")
      .format("YYYYMMDD");

    const {
      data: {
        boxOfficeResult: { dailyBoxOfficeList }
      }
    } = await axios.get("movies/dailyBoxOffice", {
      params: {
        targetDt: everyMonday,
        repNationCd: "K"
      }
    });

    this.setState({
      movies: dailyBoxOfficeList,
      isLoading: false
    });
  };

  render() {
    const { isLoading, movies } = this.state;

    return (
      <section className="container">
        {isLoading ? (
          <div className="loader">
            <span className="loader__text">Loading...</span>
          </div>
        ) : (
          <div className="movies">
            {movies.map((movie, index) => (
              <Movie key={index} id={movie.movieCd} />
            ))}
          </div>
        )}
      </section>
    );
  }
}

export default App;
