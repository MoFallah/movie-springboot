package fallah.group.moviesartifact;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String id) {
        log.info(">>>>>>>>>>>>>Service method called using @Slf4j");

        Optional<Movie> movie = movieService.singleMovie(id);
        log.info(">>>>>>>>>>>>>>>>>>>>>Error message" + movie);
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(id), HttpStatus.OK);
    }

}
