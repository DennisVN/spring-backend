package be.dennisvn.demo;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExercisesService {

    private final ExercisesRepository exercisesRepository;
    
    @Autowired
    public ExercisesService(ExercisesRepository exercisesRepository){
        this.exercisesRepository = exercisesRepository;
    }
    public List<Exercises> getExercises() {
        return exercisesRepository.findAll();
    }

    public void addNewExercises(Exercises exercises) {
        Optional<Exercises> studenOptional = exercisesRepository.findExercisesByName(exercises.getName());
        if(studenOptional.isPresent()){
            throw new IllegalStateException("Name is taken");
        }
        exercisesRepository.save(exercises);
    }
      
    public void deleteExercises(Integer exercisesId) {
        exercisesRepository.findById(exercisesId);
        boolean exists = exercisesRepository.existsById(exercisesId);
        if (!exists) {
            throw new IllegalStateException(
            "exercise with id " + exercisesId + "  does not exists");
        }
        exercisesRepository.deleteById(exercisesId);
    }

    @Transactional
    public void updateExercises(Integer exercisesId, String session, String name, Integer quadrant){
        Exercises exercises = exercisesRepository.findById(exercisesId).orElseThrow(() -> new IllegalStateException(
            "exercise with id " + exercisesId + " does not exists ! "));
        if ( name != null && name.length() > 0 && !Objects.equals(exercises.getName(), name)) {
            exercises.setName(name);
        }
        
        if ( session != null && session.length() > 0 && !Objects.equals(exercises.getSession(), session)) {
            Optional<Exercises> exercisesOptional = exercisesRepository.findExercisesBySession(session);
            if (exercisesOptional.isPresent()){
                throw new IllegalStateException("session is allready taken");
            }
        } 
       exercises.setSession(session);
    }

}
