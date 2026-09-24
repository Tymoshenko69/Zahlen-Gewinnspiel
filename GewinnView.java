import java.awt.*;
import javax.swing.*;

public class GewinnView extends JFrame {
    private JLabel lblRundenErgebnis;
    private JLabel lblGesamtpunkte;
    private JTextField txtSpielerZahl;
    private JTextField txtComputerZahl;
    private JButton btnReset;

    public GewinnView() {
        setTitle("Zahlen-Gewinnspiel (v1.0)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 250);
        setLayout(new BorderLayout(10, 10));

        // Top Panel
        JPanel topPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        JLabel lblRundHeader = new JLabel("Rundenergebnis:", SwingConstants.CENTER);
        JLabel lblPunkteHeader = new JLabel("Gesamtpunkte:", SwingConstants.CENTER);

        lblRundenErgebnis = new JLabel("", SwingConstants.CENTER);
        lblRundenErgebnis.setOpaque(true);
        lblRundenErgebnis.setBackground(Color.WHITE);

        lblGesamtpunkte = new JLabel("30", SwingConstants.CENTER);
        lblGesamtpunkte.setOpaque(true);
        lblGesamtpunkte.setBackground(Color.WHITE);

        topPanel.add(lblRundHeader);
        topPanel.add(lblPunkteHeader);
        topPanel.add(lblRundenErgebnis);
        topPanel.add(lblGesamtpunkte);

        // Center Panel
        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 10, 5));
        JLabel lblInputHeader = new JLabel("Tippe eine Zahl von 1 bis 9", SwingConstants.CENTER);
        JLabel lblCompHeader = new JLabel("Computer", SwingConstants.CENTER);

        txtSpielerZahl = new JTextField();
        txtSpielerZahl.setHorizontalAlignment(JTextField.CENTER);
        txtSpielerZahl.setFont(new Font("SansSerif", Font.BOLD, 20));

        txtComputerZahl = new JTextField();
        txtComputerZahl.setEditable(false);
        txtComputerZahl.setHorizontalAlignment(JTextField.CENTER);
        txtComputerZahl.setFont(new Font("SansSerif", Font.BOLD, 20));

        centerPanel.add(lblInputHeader);
        centerPanel.add(lblCompHeader);
        centerPanel.add(txtSpielerZahl);
        centerPanel.add(txtComputerZahl);

        // Bottom Panel
        btnReset = new JButton("Noch einmal!");
        btnReset.setEnabled(false);

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(btnReset, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
    }

    public JLabel getLblRundenErgebnis() { return lblRundenErgebnis; }
    public JLabel getLblGesamtpunkte() { return lblGesamtpunkte; }
    public JTextField getTxtSpielerZahl() { return txtSpielerZahl; }
    public JTextField getTxtComputerZahl() { return txtComputerZahl; }
    public JButton getBtnReset() { return btnReset; }
}