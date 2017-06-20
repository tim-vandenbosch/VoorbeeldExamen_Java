package be.pxl.tafelboeker.domain;

import java.io.Serializable;
import java.util.Date;

public class Boeking implements Serializable {


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    private int id;

    private String naam;

    private String straat;

    private String stad;

    private Integer uur;

    private Date dag;

    public Boeking(){
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getStad() {
        return stad;
    }

    public void setStad(String stad) {
        this.stad = stad;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Integer getUur() {
        return uur;
    }

    public void setUur(Integer uur) {
        this.uur = uur;
    }

    public Date getDag() {
        return dag;
    }

    public void setDag(Date dag) {
        this.dag = dag;
    }
}
