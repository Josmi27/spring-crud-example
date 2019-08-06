package hbcu.stay.ready.crudspringexample.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String date;

    @ManyToOne
    @JsonBackReference
    private WutangMember wutangMember;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public WutangMember getWutangMember() {
        return wutangMember;
    }

    public void setWutangMember(WutangMember wutangMember) {
        this.wutangMember = wutangMember;
    }
}
