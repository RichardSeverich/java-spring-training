package training.com.relation.models.onetomany.bidirectional;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
@Table(name = "universityb")
public class UniversityB {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Size(min = 3, max = 30)
  private String name;

  // mappedBy: tiene que existir un atributo con ese nombre en StudentB.
  @OneToMany(mappedBy = "university", cascade = CascadeType.ALL)
  private List<StudentB> listStudents;

  /**
  * Constructor.
  */
  public UniversityB() {
  }
}
