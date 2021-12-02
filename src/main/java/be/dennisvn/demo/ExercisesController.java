package be.dennisvn.demo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/exercises")
public class ExercisesController {
	private final ExercisesService exercisesService;
	// Dependency injection:
	@Autowired
	public ExercisesController(ExercisesService exercisesService) {
		this.exercisesService = exercisesService;
	}

    @GetMapping
	public List<Exercises> getExercises(){
		return exercisesService.getExercises();
	}

	@PostMapping
	public void registerNewExercises(@RequestBody Exercises exercises) {
		exercisesService.addNewExercises(exercises);
	}
	@DeleteMapping(path="{exercisesId}")
	public void deleteExercises(@PathVariable ("exercisesId") Integer exercisesId) {
		exercisesService.deleteExercises(exercisesId);
	}
	
	@PutMapping(path = "{exercisesId}")
    public void updateExercises(
        @PathVariable("exercisesId") Integer exercisesId,
        @RequestParam(required = false) String session,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) Integer quadrant){
        exercisesService.updateExercises(exercisesId, session, name, quadrant);
    }
}
