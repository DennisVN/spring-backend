package be.dennisvn.demo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

// for hibernate 
@Entity(name = "Excercises")
// for database
@Table(name = "exercises")
public class Exercises {
    @Id
    @SequenceGenerator(
        name = "exercises_sequence", 
        sequenceName = "exercises_sequence", 
        allocationSize = 1
    )
    
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "exercises_sequence"
    )

    @Column(
        name = "id",
        updatable = false
    )
    private Integer id;
    @Column(
        name = "session",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String session;
    @Column(
        name = "name",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String name; 
    @Column(
        name = "quadrant",
        nullable = false
    )
    private Integer quadrant; 

    // constructor class : 
    public Exercises(String session, String name, Integer quadrant ) {
        // super();
        // this.id = id;
        this.session = session; 
        this.name = name;
        this.quadrant = quadrant;
    }

    public Exercises() {

    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id=id;
    }
    public String getSession() {
        return session;
    }
    public void setSession(String session) {
        this.session=session;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name=name;
    }
    public Integer getQuadrant() {
        return quadrant;
    }
    public void setQuadrant(Integer quadrant) {
        this.quadrant=quadrant;
    }

    @Override
    public String toString() {
        return "Exercises{" +
                "id" + id + 
                ", session='" + session + '\'' +
                ", name='" + name + '\'' + 
                ", quadrant=" + quadrant +
                '}';
    }

}
