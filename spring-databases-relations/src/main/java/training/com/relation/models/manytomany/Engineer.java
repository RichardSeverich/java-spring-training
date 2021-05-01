package training.com.relation.models.manytomany;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
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
@Table(name = "engineer")
public class Engineer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Size(min = 3, max = 30)
  private String name;

  @ManyToMany
  @JoinTable(
    name = "engineer_course",
    joinColumns = @JoinColumn(name = "engineer_id"), 
    inverseJoinColumns = @JoinColumn(name = "course_id")
  )
  private List<Course> listCourses;

  /**
  * Constructor.
  */
  public Engineer() {
  }
}
