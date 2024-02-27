package jm.task.core.jdbc.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Dog {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column
    private String name;
    @Column
    private Byte age;
    @ManyToMany(mappedBy = "dogs")
    private List<User> users;

    public Dog(Long id, String name, Byte age, List<User> users) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.users = users;
    }

    public Dog(Long id, String name, Byte age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Dog(String name, Byte age) {
        this.name = name;
        this.age = age;
    }

    public Dog() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
