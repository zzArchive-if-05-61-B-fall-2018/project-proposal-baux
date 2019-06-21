package at.htl.model;
import javax.persistence.*;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "group.getall", query = "select g from WorkerGroup g")
})
@Table(name = "WorkerGroup")
@Entity
public class WorkerGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int groupID;
    private String groupName;

    @OneToOne
    private Worker worker;


    public WorkerGroup() {
    }

    //region Getter & Setter

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }



    //endregion

}
