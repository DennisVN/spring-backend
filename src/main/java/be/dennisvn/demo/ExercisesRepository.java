package be.dennisvn.demo;
import java.util.Optional;

// import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import be.dennisvn.demo.ExercisesRepository;


@Repository
public interface ExercisesRepository extends JpaRepository<Exercises, Integer>{
    // SELECT * FROM exercises WHERE name = ? 
    // @Query("SELECT s FROM Exercises s WHERE s.name= ?1")
    Optional<Exercises> findExercisesByName(String name);
    Optional<Exercises> findExercisesBySession(String session);
}
