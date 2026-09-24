import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GewinnController {
    private GewinnModel model;
    private GewinnView view;

    public GewinnController(GewinnModel model, GewinnView view) {
        this.model = model;
        this.view = view;

        this.view.getTxtSpielerZahl().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verarbeiteEingabe();
            }
        });

        this.view.getBtnReset().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetRunde();
            }
        });
    }

    private void verarbeiteEingabe() {
        String input = view.getTxtSpielerZahl().getText().trim();
        try {
            int zal = Integer.parseInt(input);
            if (zal < 1 || zal > 9) {
                JOptionPane.showMessageDialog(view, "Bitte eine Zahl zwischen 1 und 9 eingeben!");
                return;
            }

            model.berechneRunde(zal);
            
            view.getTxtComputerZahl().setText(String.valueOf(model.getComputerZahl()));
            view.getLblGesamtpunkte().setText(String.valueOf(model.getGesamtPunkte()));

            if (model.hatGewonnen()) {
                view.getLblRundenErgebnis().setText("Gewonnen!");
            } else if (model.hatVerloren()) {
                view.getLblRundenErgebnis().setText("Verloren!");
            } else {
                int erg = model.getRundenErgebnis();
                view.getLblRundenErgebnis().setText(erg > 0 ? "+" + erg : String.valueOf(erg));
            }

            boolean verloren = model.hatVerloren();
            view.getTxtSpielerZahl().setEnabled(!verloren);
            view.getBtnReset().setEnabled(verloren);

            if (model.getRundenErgebnis() > 0 || model.hatGewonnen()) {
                view.getLblRundenErgebnis().setBackground(Color.GREEN);
                view.getLblGesamtpunkte().setBackground(Color.GREEN);
            } else {
                view.getLblRundenErgebnis().setBackground(Color.RED);
                view.getLblGesamtpunkte().setBackground(Color.RED);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Ungültige Eingabe! Bitte eine Zahl eingeben.");
        }
    }

    private void resetRunde() {
        model.reset();
        view.getTxtSpielerZahl().setText("");
        view.getTxtComputerZahl().setText("");
        view.getLblRundenErgebnis().setText("");
        view.getLblGesamtpunkte().setText(String.valueOf(model.getGesamtPunkte()));

        view.getTxtSpielerZahl().setEnabled(true);
        view.getBtnReset().setEnabled(false);
        view.getLblRundenErgebnis().setBackground(Color.WHITE);
        view.getLblGesamtpunkte().setBackground(Color.WHITE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GewinnModel model = new GewinnModel();
            GewinnView view = new GewinnView();
            new GewinnController(model, view);
            view.setVisible(true);
        });
    }
}