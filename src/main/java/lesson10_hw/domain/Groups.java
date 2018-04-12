package lesson10_hw.domain;

import javax.persistence.*;

@Entity
@Table(name = "groups")
public class Groups {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "groups-id-gen")
    @SequenceGenerator(name = "groups-id-gen", initialValue = 100,
            allocationSize = 5, sequenceName = "alloc_groups_id")
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    public Groups(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
