package app.group;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Group {

    @Id
    private String nameOfGroup;

    public Group(String nameOfGroup) {
        this.nameOfGroup = nameOfGroup;
    }

    public String getNameOfGroup() {
        return nameOfGroup;
    }

    public void setNameOfGroup(String nameOfGroup) {
        this.nameOfGroup = nameOfGroup;
    }
}