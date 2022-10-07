package co.usa.reto3.Reto3.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer year;
    private Date startDate;
    private Date devolutionDate;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("reservation")
    private Category category;


}
