package Prueba;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Prueba extends JFrame{

    Conexion con = new Conexion();
    Connection cn = con.getConnection();
    JTextField ID = new JTextField();
    JTextField Nombre = new JTextField();
    JTextField Apellido = new JTextField();
    JTextField Domicilio = new JTextField();
    JTextField Saldo = new JTextField();
    JButton Meter = new JButton("Meter");

    public Prueba(){
        super("Prueba");
        super.setSize(250, 300);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setLayout(new GridLayout(5,1));
        super.add(ID);
        super.add(Nombre);
        super.add(Apellido);
        //super.add(Domicilio);
        super.add(Saldo);
        Meter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PreparedStatement stat = cn.prepareStatement("INSERT INTO Prue(ID,Nombre,Apellidos,Saldo) VALUES (?,?,?,?)");
                    //stat.setString(1,ID.getText());
                    stat.setString(1,ID.getText());
                    stat.setString(2,Nombre.getText());
                    stat.setString(3,Apellido.getText());
                    stat.setString(4,Saldo.getText());
                    stat.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Datos Guardados");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        super.add(Meter);
        super.setVisible(true);
    }
}
