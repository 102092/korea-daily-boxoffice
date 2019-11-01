import React from "react";
import PropTypes from "prop-types";
import axios from "axios";
import moment from "moment";
import "./Movie.css";
//여기부터 따로 추가
import "./more.css";
import jQuery from "jquery";
//레이더차트
import RadarChart from "react-svg-radar-chart";
import "react-svg-radar-chart/build/css/index.css";

//워드클라우드 - R연동
import word1 from "./img/word1.png";
import word2 from "./img/word2.png";
import word3 from "./img/word3.png";
import word4 from "./img/word4.png";
import word5 from "./img/word5.png";
import word6 from "./img/word6.png";
import word7 from "./img/word7.png";
import word8 from "./img/word8.png";
import word9 from "./img/word9.png";
import word10 from "./img/word10.png";

window.$ = window.jQuery = jQuery;
const $ = window.$;

const count = {
  count: 0,
  imgCount: 1,
  imgName: ""
};

const array_test = [""];
//레이더차트용 변수선언
const data = [
  {
    data: {
      WSD: 0.7,
      KDS: 0.8,
      DJS: 0.9,
      JPS: 0.67,
      DCS: 0.8
    },
    meta: { color: "blue" }
  }
];

const captions = {
  // columns
  WSD: "완성도",
  KDS: "가독성",
  DJS: "대중성",
  JPS: "작품성",
  DCS: "독창성"
};

class Movie extends React.Component {
  TMDB_POSTER_URI = "//image.tmdb.org/t/p/w185_and_h278_bestv2";

  state = {};

  getMovieInfo = async () => {
    const {
      data: {
        movieInfoResult: { movieInfo }
      }
    } = await axios.get("movies/movieInfo", {
      params: {
        movieCd: this.props.id
      }
    });

    const {
      data: { results }
    } = await axios.get("movies/tmdbPoster", {
      params: {
        language: "ko-KR",
        query: movieInfo.movieNm,
        year: moment(movieInfo.openDt).format("YYYY")
      }
    });

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
    this.getMovieInfo();
    array_test[1] = word1;
  }

  componentDidUpdate() {
    console.log("업데이트");
    this.countPlus();
  }

  countPlus() {
    count.count = count.count + 0.1;
    data[0].data.DJS = count.count;
    data[0].data.WSD = count.count;
    data[0].data.KDS = count.count;
    data[0].data.JPS = count.count;
    data[0].data.DCS = count.count;
    count.imgName = "word" + count.imgCount;

    console.log(count.imgCount + this.state.title);
    count.imgCount = count.imgCount + 1;

    //DB에서 데이터 가져오면 IF문 써서 title이 맞는 import imag랑 매칭시키는 방식으로
    switch (count.imgCount) {
      case 1:
        array_test[1] = word1;
        break;
      case 2:
        array_test[1] = word2;
        break;
      case 3:
        array_test[1] = word3;
        break;
      case 4:
        array_test[1] = word4;
        break;
      case 5:
        array_test[1] = word5;
        break;
      case 6:
        array_test[1] = word6;
        break;
      case 7:
        array_test[1] = word7;
        break;
      case 8:
        array_test[1] = word8;
        break;
      case 9:
        array_test[1] = word9;
        break;
      default:
        array_test[1] = word10;
    }

    // console.log(
    //   "테스트 : " + count.imgCount + "src는 :::: " + array_test[count.imgCount]
    // );
  }

  update = () => {
    console.log("여기서 데이터 바꾸는 작업");
    console.log(data[0].data.DJS);

    if ($(".Test > span").hasClass(this.state.openAt)) {
      console.log("if " + this.state.openAt);

      if ($(".Test > div").hasClass("board_" + this.state.openAt)) {
        $(".board_" + this.state.openAt).css("visibility", "visible");
      }

      $(".Test > span")
        .removeClass(this.state.openAt)
        .addClass("close" + this.state.openAt);
    } else if ($(".Test > span").hasClass("close" + this.state.openAt)) {
      console.log("else" + this.state.openAt);
      $(".Test > span")
        .removeClass("close" + this.state.openAt)
        .addClass(this.state.openAt);

      $(".Test > div").css("visibility", "hidden");
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
          <div className="Test">
            <span class={this.state.openAt} onClick={this.update}>
              <span class="blind">더보기 </span>
            </span>

            <div className={"board_" + this.state.openAt}>
              <p>리뷰내용</p>
              <div class="chartdemo">
                <RadarChart captions={captions} data={data} size={160} />
              </div>
              <div class="worddemo">
                {/* <ReactWordcloud
                  minsize={[120, 100]}
                  maxWords={15}
                  options={options}
                  words={words}
                /> */}
                <img
                  src={array_test[1]}
                  alt={count.imgName}
                  width="160"
                  height="160"
                />
              </div>
            </div>
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
