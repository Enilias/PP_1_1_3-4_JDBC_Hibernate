package jm.task.core.jdbc.model;

import javax.persistence.*;

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
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Dog(Long id, String name, Byte age, User user) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.user = user;
    }

    public Dog(String name, Byte age) {
        this.name = name;
        this.age = age;
       // this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
