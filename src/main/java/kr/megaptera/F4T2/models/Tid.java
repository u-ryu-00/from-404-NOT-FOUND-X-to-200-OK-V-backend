package kr.megaptera.F4T2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Tid {
    @Id
    @GeneratedValue
    private Long id;
    private String tid;

    public Tid(String tid) {
        this.tid = tid;
    }

    public Tid(Long id, String tid) {
        this.id = id;
        this.tid = tid;
    }

    public Long getId() {
        return id;
    }

    public String getTid() {
        return tid;
    }
}
