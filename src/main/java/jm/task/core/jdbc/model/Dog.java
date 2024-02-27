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
    /*
    @ManyToMany(mappedBy = "dogs")
    private List<User> users;
    */
    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    public Dog(Long id, String name, Byte age, User user) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.user = user;
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

    public User getUsers() {
        return user;
    }

    public void setUsers(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", user=" + user.getName() +
                '}';
    }
}
