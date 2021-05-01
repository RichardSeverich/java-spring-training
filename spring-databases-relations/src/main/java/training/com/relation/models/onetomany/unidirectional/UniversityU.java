package training.com.relation.models.onetomany.unidirectional;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
* Class.
*/
@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@Entity
@Table(name = "universityu")
public class UniversityU {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Size(min = 3, max = 30)
  private String name;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinTable(
    name = "universityu_studentu",
    joinColumns = @JoinColumn(name = "university_id"), 
    inverseJoinColumns = @JoinColumn(name = "student_id")
  )
  private List<StudentU> listStudents;

  /**
  * Constructor.
  */
  public UniversityU() {
  }
}
