package fr.wallet.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Wrapper {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;
    @OneToMany(mappedBy="wrapper", cascade=CascadeType.REMOVE)
    private List<Company> companies;
    @OneToMany(mappedBy="wrapper", cascade=CascadeType.REMOVE)
    private List<User> users;
    @OneToMany(mappedBy="wrapper", cascade=CascadeType.REMOVE)
    private List<Distribution> distributions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Distribution> getDistributions() {
        return distributions;
    }

    public void setDistributions(List<Distribution> distributions) {
        this.distributions = distributions;
    }

    @Override
    public String toString() {
        return "Wrapper{" +
                "id=" + id +
                ", companies=" + companies +
                ", users=" + users +
                ", distributions=" + distributions +
                '}';
    }
}
