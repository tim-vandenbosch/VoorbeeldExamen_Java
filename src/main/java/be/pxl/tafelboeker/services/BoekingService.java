package be.pxl.tafelboeker.services;

import be.pxl.tafelboeker.dao.BoekingDAO;
import be.pxl.tafelboeker.domain.Boeking;

import java.util.Date;
import java.util.List;

public class BoekingService {

    private BoekingDAO dao;

    public BoekingService(){
        dao = new BoekingDAO("localhost:3306","root","");
    }

    private boolean isTafelBeschikbaar(Date dag, int uur){
        return dao.isTafelBeschikbaar(dag, uur)  ;
    }

    public boolean boekTafel(Boeking boeking){
        if(isTafelBeschikbaar(boeking.getDag(), boeking.getUur())){
            dao.boekTafel(boeking);
            return true;
        }
        return false;
    }

    public List<Boeking> getAll()
    {
        List<Boeking> boekingList = dao.allBoeking();
        if(boekingList != null)
        {
            return boekingList;
        }
        else {
            return null;
        }
    }
}
