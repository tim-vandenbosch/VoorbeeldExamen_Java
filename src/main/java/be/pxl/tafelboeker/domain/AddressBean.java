package be.pxl.tafelboeker.domain;

import java.io.Serializable;

/**
 * Created by Ben on 6/19/2017.
 */
public class AddressBean implements Serializable {

        private String straat;
        private String stad;

    public AddressBean() {
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
}
