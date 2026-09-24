import java.util.Random;

public class GewinnModel {
    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;
    private final Random random;

    public GewinnModel() {
        this.gesamtPunkte = 30;
        this.random = new Random();
    }

    public void reset() {
        this.gesamtPunkte = 30;
        this.spielerZahl = 0;
        this.computerZahl = 0;
        this.rundenErgebnis = 0;
    }

    public int getGesamtPunkte() {
        return gesamtPunkte;
    }

    public int getComputerZahl() {
        return computerZahl;
    }

    public int getRundenErgebnis() {
        return rundenErgebnis;
    }

    public void berechneComputerZahl() {
        this.computerZahl = random.nextInt(9) + 1;
    }

    public void berechneRunde(int spielerZahl) {
        this.spielerZahl = spielerZahl;
        berechneComputerZahl();

        int diff = Math.abs(this.spielerZahl - this.computerZahl);

        if (diff == 0) {
            this.rundenErgebnis = 20;
        } else if (diff == 1) {
            this.rundenErgebnis = 5;
        } else {
            this.rundenErgebnis = -10;
        }

        this.gesamtPunkte += this.rundenErgebnis;
    }
    
    public boolean hatGewonnen() {
        return gesamtPunkte >= 100;
    }

    public boolean hatVerloren() {
        return gesamtPunkte < 0;
    }
}