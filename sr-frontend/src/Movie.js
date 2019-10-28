import React from "react";
import PropTypes from "prop-types";
import axios from "axios";
import moment from "moment";
import querystring from "querystring";
import "./Movie.css";
import "./more.css";
//import "./more.js";
import jQuery from "jquery";
window.$ = window.jQuery = jQuery;
const $ = window.$;

class Movie extends React.Component {
  KOBIS_KEY = "e0e16996d75f4cc203eb802ace6fae55";

  KOBIS_MOVIE_URI =
    "//www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json";

  TMDB_KEY = "6d3a7fab8fd7268369688995d40bc8e5";

  TMDB_SEARCH_URI = "//api.themoviedb.org/3/search/movie";

  TMDB_POSTER_URI = "//image.tmdb.org/t/p/w185_and_h278_bestv2";

  state = {};

  getMovie = async () => {
    const {
      data: {
        movieInfoResult: { movieInfo }
      }
    } = await axios.get(
      `${this.KOBIS_MOVIE_URI}?${querystring.stringify({
        key: this.KOBIS_KEY,
        movieCd: this.props.id
      })}`
    );

    const {
      data: { results }
    } = await axios.get(
      `${this.TMDB_SEARCH_URI}?${querystring.stringify({
        api_key: this.TMDB_KEY,
        language: "ko-KR",
        query: movieInfo.movieNm,
        year: moment(movieInfo.openDt).format("YYYY")
      })}`
    );

    movieInfo["poster"] = results.length
      ? this.TMDB_POSTER_URI + results[0].poster_path
      : `//via.placeholder.com/185x278/000000?text=Not found Poster`;

    this.parseInfo(movieInfo);
  };

  parseInfo = movie => {
    this.setState({
      title: movie.movieNm,
      subtitle: movie.movieNmEn,
      openAt: moment(movie.openDt).format("YYYY-MM-DD"),
      status: movie.prdtStatNm,
      audits: movie.audits[0].watchGradeNm,
      showTimes: `${movie.showTm}분`,
      nations: movie.nations[0].nationNm,
      directors: movie.directors.map(director => director.peopleNm).join(" / "),
      genres: movie.genres.map(genre => genre.genreNm).join("/"),
      distributor: movie.companys
        .filter(company => company.companyPartNm === "배급사")
        .map(company => company.companyNm)
        .join(", "),
      poster: movie.poster
    });
  };

  componentDidMount() {
    this.getMovie();
  }

  componentDidUpdate() {
    console.log("업데이트");
  }

  update = () => {
    if ($(".more").hasClass("more")) {
      console.log("if " + this.state.title);
      $(".more")
        .addClass("close")
        .removeClass("more");
      $(".board").css("visibility", "visible");
    } else if ($(".close").hasClass("close")) {
      console.log("else" + this.state.title);
      $(".close")
        .addClass("more")
        .removeClass("close");
      $(".board").css("visibility", "hidden");
    }
  };

  render() {
    return (
      <div className="movie">
        <img src={this.state.poster} alt={this.state.title} />

        <div className="movie__data">
          <div className="movie__header">
            <h4 className="movie__title">{this.state.title}</h4>
            <h5 className="movie__subtitle">{this.state.subtitle}</h5>
          </div>

          <div className="movie__info">
            <p className="movie__openat">
              <span>개봉일</span> {this.state.openAt}
            </p>

            <p className="movie__status">
              <span>제작상태</span> {this.state.status}
            </p>
          </div>

          <div className="movie__info">
            <p className="movie__audits">
              <span>관람등급</span> {this.state.audits}
            </p>

            <p className="movie__showtimes">
              <span>상영시간</span> {this.state.showTimes}
            </p>

            <p className="movie__nations">
              <span>제작국가</span> {this.state.nations}
            </p>
          </div>

          <div className="movie__info">
            <p className="movie__directors">
              <span>감독</span> {this.state.directors}
            </p>

            <p className="movie__genres">
              <span>장르</span> {this.state.genres}
            </p>

            <p className="movie__distributor">
              <span>배급사</span> {this.state.distributor}
            </p>
          </div>

          <div className="movie__info">
            <p className="movie__review">
              <a href={"https://www.naver.com"}> 리뷰 더보기 </a>
            </p>
          </div>
          <span class="more" onClick={this.update}>
            <span class="blind">더보기 V</span>
          </span>
          <div class="board">
            <ul class="list">
              <li>가계부</li>
              <li>날씨</li>
              <li>네이버 예약</li>
              <li>네이버 캐스트</li>
              <li>네이버 클라우드</li>
            </ul>
            <ul class="list">
              <li>만화 / 웹툰</li>
              <li>매거진캐스트</li>
              <li>메모</li>
              <li>뮤직</li>
              <li>부동산</li>
            </ul>
            <ul class="list">
              <li>영화</li>
              <li>오디오클립</li>
              <li>오피스</li>
              <li>웹소설</li>
              <li>자동차</li>
            </ul>
          </div>
        </div>
      </div>
    );
  }
}

Movie.propTypes = {
  id: PropTypes.string.isRequired
};

export default Movie;
