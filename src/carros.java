import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class carros {
    public JFrame v;
    public JTextPane instrucccion;
    public JTextField placa;
    public JTextField marca;
    public JTextField cilindraje;
    public JTextField combustible;
    public JTextField color;
    public JTextField popietario;
    public JButton ingresarbtn;
    public JButton borrarbtn;
    public JPanel from1;
    public JTextArea titulo;
    public JTextPane ingreseLaPlacaTextPane;
    public JTextPane marcaTextPane;
    public JTextPane cilindrajeTextPane;
    public JTextPane tipoDeCobustibleTextPane;
    public JTextPane colorTextPane;
    public JTextPane propietarioDelVehiculoTextPane;
    public JButton buscarbtn;
    public JTextPane igreseLaPlacaATextPane;
    public JTextField buscarveh;
    private JLabel imprimir;
    public Connection connection;

    public carros() {
        ingresarbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String placaregis = placa.getText();
                String marcaregis = marca.getText();
                double cilindrajeregis = Double.parseDouble(cilindraje.getText());
                String combustibleregis = combustible.getText();
                String colorregis = color.getText();
                String propietarioregis = popietario.getText();

                Vehiculos vehiculos = new Vehiculos(placaregis, marcaregis, cilindrajeregis, combustibleregis, colorregis, propietarioregis);
                String url = "jdbc:mysql://localhost:3306/vehiculos2024";
                String user = "root";
                String password = "123456";

                String sql = "INSERT INTO vehiculo (placa, marca, cilindraje, tipoCombustible, color, propietario) VALUES (?,?,?,?,?,?)";

                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                    PreparedStatement cadenaPreparada = connection.prepareStatement(sql);

                    cadenaPreparada.setString(1, placaregis);
                    cadenaPreparada.setString(2, marcaregis);
                    cadenaPreparada.setDouble(3, cilindrajeregis);
                    cadenaPreparada.setString(4, combustibleregis);
                    cadenaPreparada.setString(5, colorregis);
                    cadenaPreparada.setString(6, propietarioregis);
                    cadenaPreparada.executeUpdate();

                    JOptionPane.showMessageDialog(from1, "Se ha registrado el vehiculo!");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(from1, "Error al registrar el vehiculo", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        borrarbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placa.setText("");
                marca.setText("");
                cilindraje.setText("");
                combustible.setText("");
                color.setText("");
                popietario.setText("");
                JOptionPane.showMessageDialog(from1, "Se limpio el formulario!");
            }
        });

        buscarbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String placabuscar = buscarveh.getText();

                String url = "jdbc:mysql://localhost:3306/vehiculos2024";
                String user = "root";
                String password = "123456";

                String sql = "SELECT * FROM vehiculo WHERE placa =?";

                try (Connection conn = DriverManager.getConnection(url, user, password)) {
                    PreparedStatement cadenaPreparada = conn.prepareStatement(sql);
                    cadenaPreparada.setString(1, placabuscar);
                    ResultSet resultSet = cadenaPreparada.executeQuery();

                    if (resultSet.next()) {
                        String placa = resultSet.getString("placa");
                        String marca = resultSet.getString("marca");
                        double cilindraje = resultSet.getDouble("cilindraje");
                        String tipoCombustible = resultSet.getString("tipoCombustible");
                        String color = resultSet.getString("color");
                        String propietario = resultSet.getString("propietario");
                        imprimir.setText("<html>Placa: " + placa + "<br>Marca: " + marca +
                        "<br>Cilindraje: " + cilindraje + "<br>Combustible: " + tipoCombustible +
                                "<br>Color: " + color + "<br>Propietario: " + propietario + "</html>");

                        JOptionPane.showMessageDialog(from1, "Vehiculo encontrado!");


                    } else {
                        JOptionPane.showMessageDialog(from1, "Vehiculo no encontrado!");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(from1, "Error al buscar el vehiculo", "Error", JOptionPane.ERROR_MESSAGE);
                }
                }
        });
    }
}

