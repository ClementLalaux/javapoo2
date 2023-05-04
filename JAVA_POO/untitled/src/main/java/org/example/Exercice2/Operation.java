package org.example.Exercice2;




public class Operation {

    private int id;
    private String nomOperation;
    private float montant;
    private int compteId;
    private static String request;
    private static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet resultSet;

    public Operation(String nomOperation, float montant, int compteId) {
        this.nomOperation = nomOperation;
        this.montant = montant;
        this.compteId = compteId;
    }

    public Operation(int id,String nomOperation, float montant, int compteId) {
        this(nomOperation, montant, compteId);
        this.id = id;
    }

    public boolean save() throws SQLException {
        request = "INSERT INTO email (mail, contact_id) values (?, ?)";
        connection = new DataBaseManager().getConnection();
        statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, getMail());
        statement.setInt(2, getContactId());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(resultSet.next()){
            this.id = resultSet.getInt(1);
        }
        return nbRow == 1;
    }

}
