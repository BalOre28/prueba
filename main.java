package BlockBusterItem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class main extends JFrame {
    private BlockBuster blockBuster;

    public main() {
        blockBuster = new BlockBuster();

        setTitle("BlockBuster");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Opciones");

        JMenuItem buscarItemMenuItem = new JMenuItem("Buscar Ítem");
        buscarItemMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarItem();
            }
        });
        menu.add(buscarItemMenuItem);

        JMenuItem agregarItemMenuItem = new JMenuItem("Agregar item");
        agregarItemMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarItem();
            }
        });
        menu.add(agregarItemMenuItem);

        JMenuItem rentarItemMenuItem = new JMenuItem("Rentar item");
        rentarItemMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rentarItem();
            }
        });
        menu.add(rentarItemMenuItem);

        JMenuItem auditarEstadoMenuItem = new JMenuItem("Auditar Estado de Peliculas");
        auditarEstadoMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                auditarEstado();
            }
        });
        menu.add(auditarEstadoMenuItem);

        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    private void buscarItem() {
        // Aquí puedes implementar la ventana de búsqueda de ítems
    }

    private void agregarItem() {
        JFrame agregarItemFrame = new JFrame("Agregar Ítem");
        agregarItemFrame.setSize(300, 200);
        agregarItemFrame.setLayout(new GridLayout(4, 2));

        JLabel codigoLabel = new JLabel("Código:");
        JTextField codigoField = new JTextField();
        JLabel nombreLabel = new JLabel("Nombre:");
        JTextField nombreField = new JTextField();
        JLabel tipoLabel = new JLabel("Tipo (MOVIE/GAME):");
        JTextField tipoField = new JTextField();

        JButton agregarButton = new JButton("Agregar");

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigo = Integer.parseInt(codigoField.getText());
                String nombre = nombreField.getText();
                String tipo = tipoField.getText();
                blockBuster.agregarItem(codigo, nombre, tipo);
                agregarItemFrame.dispose();
            }
        });

        agregarItemFrame.add(codigoLabel);
        agregarItemFrame.add(codigoField);
        agregarItemFrame.add(nombreLabel);
        agregarItemFrame.add(nombreField);
        agregarItemFrame.add(tipoLabel);
        agregarItemFrame.add(tipoField);
        agregarItemFrame.add(agregarButton);

        agregarItemFrame.setVisible(true);
    }

    private void rentarItem() {
  JFrame rentarItemFrame = new JFrame("Rentar item");
    rentarItemFrame.setSize(300, 200);
    rentarItemFrame.setLayout(new GridLayout(4, 2));

    JLabel codigoLabel = new JLabel("Código:");
    JTextField codigoField = new JTextField();
    JLabel tipoLabel = new JLabel("Tipo (MOVIE/GAME):");
    JTextField tipoField = new JTextField();
    JLabel diasLabel = new JLabel("Días de renta:");
    JTextField diasField = new JTextField();

    JButton rentarButton = new JButton("Rentar");

    rentarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int codigo = Integer.parseInt(codigoField.getText());
            String tipo = tipoField.getText();
            int dias = Integer.parseInt(diasField.getText());
            blockBuster.rentar(codigo, tipo, dias);
            rentarItemFrame.dispose();
        }
    });

    rentarItemFrame.add(codigoLabel);
    rentarItemFrame.add(codigoField);
    rentarItemFrame.add(tipoLabel);
    rentarItemFrame.add(tipoField);
    rentarItemFrame.add(diasLabel);
    rentarItemFrame.add(diasField);
    rentarItemFrame.add(rentarButton);

    rentarItemFrame.setVisible(true);

    }

    private void auditarEstado() {
        blockBuster.auditarMovieEstados();
        JOptionPane.showMessageDialog(this, "Auditoría de estado de películas completada.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                main main = new main();
                main.setVisible(true);
            }
        });
    }
}