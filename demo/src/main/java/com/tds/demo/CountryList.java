package com.tds.demo;

import java.util.ArrayList;
import java.util.List;

public class CountryList {
    private List country;
    private String name;
    private String capital;
    public List getCountry() {
        return country;
    }

    public void setCountry(List country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public CountryList() {
        country = new ArrayList<>();
        country.add(name);
        country.add(capital);
    }
}
