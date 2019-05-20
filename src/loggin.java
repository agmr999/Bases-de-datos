import Prueba.Conexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class loggin extends JFrame {

    Conexion con;
    private ImageIcon imagen;

    public loggin() {
        super("Usuarios");
        super.setSize(250, 230);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/g3162.png")).getImage());
        ((JPanel)getContentPane()).setOpaque(false);
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/imagenes/g3162.png"));
        JLabel fondo= new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
        iniciarcomp();
        super.setVisible(true);
    }

    private void iniciarcomp(){
        setLayout(new BorderLayout());
        JPanel pn3 = new JPanel();
        pn3.setLayout(new GridLayout(3,1));
        JPanel pn1 = new JPanel();
        JPanel pn2 = new JPanel();
        JLabel lab1 = new JLabel("  ");
        JButton aceptar = new JButton("Entrar");
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                con = new Conexion();
                Connection reg = con.getConnection();
            }
        });
        JLabel usuario = new JLabel("USUARIO     ");
        JTextField usu =new JTextField(8);
        pn1.setLayout(new FlowLayout());
        pn1.add(usuario);
        pn1.add(usu);
        pn1.setOpaque(false);
        JLabel contraseña = new JLabel("Contraseña");
        JTextField cont =new JTextField(8);
        pn2.setLayout(new FlowLayout());
        pn2.add(contraseña);
        pn2.add(cont);
        pn3.add(lab1);
        pn3.add(pn1);
        pn3.add(pn2);
        pn3.setOpaque(false);
        add(pn3);
        add(aceptar,BorderLayout.SOUTH);
        pn2.setOpaque(false);
    }

}
/*metodo wait y medoto notify, notifyall*/