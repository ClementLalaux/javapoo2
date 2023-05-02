package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Inscrit {

    private int id;
    private String nom;
    private String prenom;
    private String telephone;

    public static String request;
    public static PreparedStatement statement;
    public static Connection connection;

    public Inscrit(String nom, String prenom, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }

    public Inscrit(int id,String nom, String prenom, String telephone) {
        this(nom, prenom, telephone);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean ajouter() throws SQLException {
        request = "INSERT INTO contact (nom,prenom,telephone) " +
                "VALUES (?,?,?)";
        connection = new DataBaseManager().getConnection();
        statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1,nom);
        statement.setString(2,prenom);
        statement.setString(3,telephone);

        int row = statement.executeUpdate();
        return  row >0;
    }

    public boolean delete() throws SQLException{
        request = "DELETE FROM contact where id = ?";
        connection = new DataBaseManager().getConnection();
        statement = connection.prepareStatement(request);
        statement.setInt(1,getId());
        int row = statement.executeUpdate();
        return row>0;
    }

    public  static Inscrit getById(int id) throws SQLException{
        Inscrit inscrit = null;
        request = "SELECT * FROM contact WHERE id = ?";
        connection = new DataBaseManager().getConnection();
        statement = connection.prepareStatement(request);
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            inscrit = new Inscrit(resultSet.getString("nom"),resultSet.getString("prenom"),resultSet.getString("telephone"));

        }
      return inscrit;
    }


    public static List<Inscrit> getAll() throws SQLException {
      List<Inscrit> result  = new ArrayList<>();
      request = "SELECT * FROM contact";
      connection = new DataBaseManager().getConnection();
      statement = connection.prepareStatement(request);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()){
        Inscrit i = new Inscrit(resultSet.getInt("idcontact"),resultSet.getString("nom"),resultSet.getString("prenom"),resultSet.getString("telephone"));
        result.add(i);
      }
        return result;
    }

    public static List<Inscrit> getByNumber(String tel) throws SQLException {
        List<Inscrit> result = new ArrayList<>();
        request = "SELECT * FROM contact where telephone LIKE ?";
        connection = new DataBaseManager().getConnection();
        statement = connection.prepareStatement(request);
        statement.setString(1, '%' + tel + '%');
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Inscrit s = new Inscrit(resultSet.getInt("idcontact"),resultSet.getString("nom"), resultSet.getString("prenom"), resultSet.getString("telephone"));
            result.add(s);
        }
        return result;
    }


    @Override
    public String toString() {
        return "Inscrit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
