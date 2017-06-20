package be.pxl.tafelboeker.dao;

import be.pxl.tafelboeker.domain.Boeking;

import javax.persistence.*;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.Class.forName;

public class BoekingDAO {

    private String url;
    private String user;
    private String password;

    public BoekingDAO(String url,String user, String password){
        this.url = url;
        this.user = user;
        this.password = password;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    // TIP : Gebruik TemporalType.DATE voor je query parameter
    public boolean isTafelBeschikbaar(Date dag, int uur){

        String sql = "SELECT * FROM booking where DAY = ? and HOUR = ?";
        try(Connection con = DriverManager.getConnection("jdbc:mysql://"+ this.url + "/boekingdb", this.user, this.password)){
            try(PreparedStatement queryStatement = con.prepareStatement(sql))
            {
                queryStatement.setDate(1, new java.sql.Date(dag.getTime()));
                queryStatement.setInt(2,uur);
                ResultSet set = queryStatement.executeQuery();
                if(set.next())
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }
            catch(SQLException ex)
            {
                ex.printStackTrace();
                return false;
            }
        }
        catch(SQLException ex)
        {
                ex.printStackTrace();
                return false;
        }
    }

    public void boekTafel(Boeking boeking)
    {
         String query = "INSERT INTO booking(DAY,NAME,CITY,STREET,HOUR) VALUES(?,?,?,?,?)";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://" + this.url + "/boekingdb", this.user, this.password)) {
            try (PreparedStatement insertStatement = con.prepareStatement(query)) {
                insertStatement.setDate(1, new java.sql.Date(boeking.getDag().getTime()));
                insertStatement.setString(2,boeking.getNaam());
                insertStatement.setString(3,boeking.getStad());
                insertStatement.setString(4,boeking.getStraat());
                insertStatement.setInt(5,boeking.getUur());
                insertStatement.executeUpdate();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }
    }


    public List<Boeking> allBoeking(){

        List<Boeking> boekingList = new ArrayList<>();
        String sql = "Select * from booking";
        try(Connection con = DriverManager.getConnection("jdbc:mysql://"+ this.url + "/boekingdb", this.user, this.password)){
            try(Statement statement = con.createStatement())
            {
               ResultSet result =  statement.executeQuery(sql);
                while(result.next())
                {

                    int id = result.getInt("id");
                    Date date = result.getDate("DAY");
                    String name = result.getString("NAME");
                    String city = result.getString("CITY");
                    String street = result.getString("STREET");
                    int hour = result.getInt("HOUR");

                    Boeking boek = new Boeking();

                    boek.setId(id);
                    boek.setDag(date);
                    boek.setNaam(name);
                    boek.setStad(city);
                    boek.setStraat(street);
                    boek.setUur(hour);
                    boekingList.add(boek);
                }
                return boekingList;
            }
            catch(SQLException ex)
            {
                ex.printStackTrace();
                return null;
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

}
