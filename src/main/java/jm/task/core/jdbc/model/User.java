package jm.task.core.jdbc.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private Byte age;
    /*
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "communication_tables",joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "dog_id"))
    /*
    https://www.baeldung.com/jpa-many-to-many
    Обратите внимание, что использование @JoinTable  или даже @JoinColumn не требуется.
    JPA сгенерирует для нас имена таблиц и столбцов.
    Однако стратегия, которую использует JPA, не всегда соответствует используемым нами соглашениям об именах.
    Итак, нам нужна возможность настройки имен таблиц и столбцов.

    private List<Dog> dogs;
    */
    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Dog> dogs;

    public User() {

    }

    public User(Long id, String name, String lastName, Byte age, List<Dog> dogs) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.dogs = dogs;
    }

    public User(String name, String lastName, Byte age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public User(String name, String lastName, Byte age, List<Dog> dogs) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.dogs = dogs;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{id = ").append(id)
                .append(" name = ").append(name)
                .append(" lastName = ").append(lastName)
                .append(" age = ").append(age)
                .append(" dog = ").append(dogs)
                .append("}")
                .append("\n");
        return sb.toString();
    }
}
