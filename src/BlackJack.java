import java.util.Random;
import java.util.Scanner;

public class BlackJack {

	public static void main(String[] args) {
		
		int black = 21;
		int carta = 1;
		Random rand = new Random();
		
		System.out.println("Ecco la tua prima carta:");
		do {
			carta = rand.nextInt(13);
		}while(carta == 0);
		System.out.print(carta);
		System.out.println();
		int s = carta;
		aggiungiCarte(s, black);
		
	}
	
	public static void aggiungiCarte(int s, int black) {
		
		while (s < black) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Vuoi aggiungere una nuova carta? (y/n)");
		String risposta = scan.next();
		Random rand = new Random();
		int newcarta = 0;
		if(risposta.equals("y")) {
			while(newcarta == 0){
				newcarta = rand.nextInt(13);
			};
			s = newcarta + s;
			
			System.out.println("Ecco la carta aggiunta: " +newcarta);
			System.out.println("Ecco il valore delle tue carte:" +s);
			System.out.println();
			if(s > black) {
				System.out.println("Che peccato hai sballato!");
			}else
				if(s == black) {
					System.out.println("Complimenti! Hai vinto!");
				}
			
		}else
			if(risposta.equals("n")) {
				turnoPC(s, black);
				break;
			}
		}
	}
	
	public static void turnoPC(int s, int black) {
		
		System.out.println("Adesso è il turno del PC");
		Random rand = new Random();
		int carta = 0;
		while(carta == 0){
			carta = rand.nextInt(13);
		};
		System.out.println("Ecco la carta del PC: " +carta);
		int sommaPC = carta;
		while(sommaPC < black) {
			if(sommaPC < 15) {
				while(carta == 0){
					carta = rand.nextInt(13);
				};
				System.out.println("Ecco la nuova carta del PC: " +carta);
				sommaPC = sommaPC + carta;
				System.out.println("Ed il totale: " +sommaPC);
			}else
				if(sommaPC <black) {
					System.out.println("Il PC si ferma.");
					if(sommaPC < s) {
						System.out.println("Il PC perde " +sommaPC +" a " +s);
					}else if(sommaPC == s) {
						System.out.println("E' PATTA! " +sommaPC +" E " +s);
						break;
					}else if(sommaPC > s) {
						System.out.println("Vince comunque il PC " +sommaPC +" a " +s);
					}
				}
				if(sommaPC == black) {
					
					System.out.println("Che peccato! Vince il PC!");
					break;
				}
				if(sommaPC > black) {
					
					System.out.println("Il PC sballa! Hai vinto!");
					break;
				}
		}
	}
}
