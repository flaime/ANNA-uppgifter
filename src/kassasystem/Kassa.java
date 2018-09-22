package kassasystem;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.util.*;

class Kassa extends JFrame{
	final String[] VAROR = {"Gurka", "Paprika", "Tomat",
			"Mjölk", "Yoghurt", "Grädde",
			"Bröd", "Müsli", "Kakor"};
//	final HashMap<String,ArrayList<Vara>> varukattegorier = new HashMap<>();


	final VaroRegister varoRegister = new VaroRegister();

	final private ArrayList<Vara> köpt = new ArrayList<>();

	final JButton kvitto = new JButton("Kvitto");

	public Kassa(){
		super("Kassa");
		initVaror();
		JPanel north = new JPanel();
		add(north, BorderLayout.NORTH);

		JButton nyKundKnapp = new JButton("Ny kund");
		north.add(nyKundKnapp);

		kvitto.addActionListener(x->{
			JFrame kvittoWinov = new JFrame("Kvitto");

			kvittoWinov.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			kvittoWinov.add(kvitto("hej"));
			kvittoWinov.setSize(150,350);
			kvittoWinov.setVisible(true);
		});

		JPanel center = new JPanel();
		center.setLayout(new GridLayout(2,1));
		add(center, BorderLayout.CENTER);

		center.add(getCategoryPanel());
		JTextArea display = new JTextArea();
		center.add(new JScrollPane(display));

		JPanel south = new JPanel();
		add(south, BorderLayout.SOUTH);
		south.add(new JLabel("Antal: "));
		south.add(new JTextField(5));
		south.add(new JLabel("Totalbelopp = "));
		south.add(new JLabel("0"));

		JPanel east = new JPanel();
		east.setLayout(new BoxLayout(east,BoxLayout.Y_AXIS));
		add(east,BorderLayout.EAST);
		east.add(kvitto);
		east.add(new JButton("Rensa"));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
	}

	private JPanel getCategoryPanel() {
		JPanel knappar = new JPanel();

		int rows = 3;
		//Säkerställer att det alltid blir x antal rader så att alla varor får platts
		int columns = (int) Math.ceil(varoRegister.antalVarukattegorier()/rows);
		knappar.setLayout(new GridLayout(rows,columns,10,10));

		for(String kattegori : varoRegister.getAllKattegorier()){
			JButton b = new JButton(kattegori);
			b.addActionListener(x->{
				JFrame kvittoWinov = new JFrame("Kvitto");

				kvittoWinov.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				kvittoWinov.add(varuFönster(varoRegister.getVaror(kattegori)));
				kvittoWinov.setSize(350,150);
				kvittoWinov.setVisible(true);
			});
			knappar.add(b);
			String tid = LocalTime.now().toString();
		}

		return knappar;
	}

	private void initVaror() {
		varoRegister.addVara("Mejeriprodukt", new Vara("Mjölk",10,2.5));
		varoRegister.addVara("Mejeriprodukt", new Vara("Smör",15,5.0));
		varoRegister.addVara("Mejeriprodukt", new Vara("Ost",30,3.4));
		varoRegister.addVara("Bröd", new Vara("Knäckebröd",7,1.0));
		varoRegister.addVara("Bröd", new Vara("Mjukbröd",10,1.3));
	}

	private JPanel kvitto(String somthing){
		JPanel kvitto = new JPanel();
		kvitto.setLayout(new BorderLayout());
		String kvittoText = "";

		//här skall logiken för att lägga till texten i kvittoTexten

		JTextArea kvittoTexten = new JTextArea(kvittoText);
//		kvittoTexten.setColumns(150);
		JScrollPane jScrollPane = new JScrollPane(kvittoTexten);
//		jScrollPane.
		kvitto.add(jScrollPane,BorderLayout.CENTER);
		return kvitto;
	}

	private JPanel varuFönster(Collection<Vara> varor){
		JPanel knappar = new JPanel();
		int rows = 3;
		//Säkerställer att det alltid blir x antal rader så att alla varor får platts
		int columns = (int) Math.ceil(varor.size()/rows);
		knappar.setLayout(new GridLayout(rows,columns,10,10));

		for(int i = 0; i < VAROR.length; i++){
			JButton b = new JButton(VAROR[i]);
//			final Vara ii = VAROR[i];
			b.addActionListener(event->{
//				köpt.add(ii);
				event.getSource();
			});
			//lägga till logiken för vad som händer för när man trycker på knappen
			knappar.add(b);
		}
		return knappar;
	}

	public static void main(String[] args){
		new Kassa();
	}
}
