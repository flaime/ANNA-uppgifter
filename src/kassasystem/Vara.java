package kassasystem;

public class Vara {

	String namn;
	int pris;
	double vikt;

	public Vara(String namn, int pris, double vikt) {
		this.namn = namn;
		this.pris = pris;
		this.vikt = vikt;
	}

	public String getNamn() {
		return namn;
	}

	public void setNamn(String namn) {
		this.namn = namn;
	}

	public int getPris() {
		return pris;
	}

	public void setPris(int pris) {
		this.pris = pris;
	}

	public double getVikt() {
		return vikt;
	}

	public void setVikt(double vikt) {
		this.vikt = vikt;
	}
}
