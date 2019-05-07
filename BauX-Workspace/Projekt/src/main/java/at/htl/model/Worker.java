package at.htl.model;


import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "nn", query = "select d from Worker d")
})

@Table
@Entity
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Name;
    private int workedHours;


    public Worker() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String firstName, String lastName) {
        Name = firstName + ' ' + lastName;
    }

    public int getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(int workedHours) {
        this.workedHours = workedHours;
    }

}
