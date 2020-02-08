package composants;

import java.util.ArrayList;

import entit�s.Animal;

/**
 * Classe d�terminant une Carte. Une carte contient deux Podiums
 * 
 * @author BOUCHET Ulysse & VIGNARAJAH Daran
 * @version 1.3 27/02/2019
 */
public class Carte {
	/**
	 * Premier podium, le podium bleu
	 * @see Podium
	 */
	private Podium bleu = new Podium();
	/**
	 * Second podium, le podium rouge
	 * @see Podium
	 */
	private Podium rouge = new Podium();


	/**
	 * V�rifie si deux cartes sont �gales
	 * 
	 * @param c la 2�me carte
	 * @return un boolean true si les cartes sont les m�mes, false sinon
	 * @see Podium#hasSameAnimals(Podium)
	 */
	public boolean isSameAs(Carte c) {
		if (this.getBleu().hasSameAnimals(c.getBleu())
				&& this.getRouge().hasSameAnimals(c.getRouge()))
			return true;
		else
			return false;
	}
	
	/**
	 * G�n�re les 24 cartes possibles
	 * 
	 * @return la liste des 24 cartes possibles
	 * 
	 * @see Carte
	 * @see Podium
	 * @see Animal
	 */
	public static ArrayList<Carte> generateCartes() {
		ArrayList<Carte> cartes = new ArrayList<>();
		Carte tmp1;
		Carte tmp2;
		for (int o = 1; o <= 3; ++o)
			for (int l = 1; l <= 3; ++l)
				for (int e = 1; e <= 3; ++e) {
					if (o + l + e == 6 && !(o == 2 && e == 2 && l == 2)) {
						tmp1 = new Carte();
						tmp2 = new Carte();

						tmp1.getBleu().getAnimaux().set(o - 1, Animal.OURS);
						tmp1.getBleu().getAnimaux().set(l - 1, Animal.LION);
						tmp1.getBleu().getAnimaux().set(e - 1, Animal.ELEPHANT);
						cartes.add(tmp1);

						tmp2.getRouge().getAnimaux().set(o - 1, Animal.OURS);
						tmp2.getRouge().getAnimaux().set(l - 1, Animal.LION);
						tmp2.getRouge().getAnimaux().set(e - 1, Animal.ELEPHANT);
						cartes.add(tmp2);
					}
					if (o == 3 && l + e == 3) {
						tmp1 = new Carte();
						tmp2 = new Carte();

						tmp1.getBleu().getAnimaux().set(0, Animal.OURS);
						tmp1.getRouge().getAnimaux().set(l - 1, Animal.LION);
						tmp1.getRouge().getAnimaux().set(e - 1, Animal.ELEPHANT);
						cartes.add(tmp1);

						tmp2.getRouge().getAnimaux().set(0, Animal.OURS);
						tmp2.getBleu().getAnimaux().set(l - 1, Animal.LION);
						tmp2.getBleu().getAnimaux().set(e - 1, Animal.ELEPHANT);
						cartes.add(tmp2);
					}
					if (l == 3 && o + e == 3) {
						tmp1 = new Carte();
						tmp2 = new Carte();

						tmp1.getBleu().getAnimaux().set(0, Animal.LION);
						tmp1.getRouge().getAnimaux().set(o - 1, Animal.OURS);
						tmp1.getRouge().getAnimaux().set(e - 1, Animal.ELEPHANT);
						cartes.add(tmp1);

						tmp2.getRouge().getAnimaux().set(0, Animal.LION);
						tmp2.getBleu().getAnimaux().set(o - 1, Animal.OURS);
						tmp2.getBleu().getAnimaux().set(e - 1, Animal.ELEPHANT);
						cartes.add(tmp2);
					}
					if (e == 3 && l + o == 3) {
						tmp1 = new Carte();
						tmp2 = new Carte();

						tmp1.getBleu().getAnimaux().set(0, Animal.ELEPHANT);
						tmp1.getRouge().getAnimaux().set(l - 1, Animal.LION);
						tmp1.getRouge().getAnimaux().set(o - 1, Animal.OURS);
						cartes.add(tmp1);

						tmp2.getRouge().getAnimaux().set(0, Animal.ELEPHANT);
						tmp2.getBleu().getAnimaux().set(l - 1, Animal.LION);
						tmp2.getBleu().getAnimaux().set(o - 1, Animal.OURS);
						cartes.add(tmp2);
					}
				}
		return cartes;
	}

	//Getters & Setters
	
	/**
	 * Getter du podium bleu
	 * @return le podium bleu
	 * @see Carte#bleu
	 * @see Podium
	 */
	public Podium getBleu() {
		return bleu;
	}

	/**
	 * Setter du podium bleu
	 * @param bleu le nouveau podium bleu
	 * @see Carte#bleu
	 * @see Podium
	 */
	public void setBleu(Podium bleu) {
		this.bleu = bleu;
	}
	
	/**
	 * Getter du podium rouge
	 * @return le podium rouge
	 * @see Carte#rouge
	 * @see Podium
	 */
	public Podium getRouge() {
		return rouge;
	}

	/**
	 * Setter du podium rouge
	 * @param rouge le nouveau podium rouge
	 * @see Carte#rouge
	 * @see Podium
	 */
	public void setRouge(Podium rouge) {
		this.rouge = rouge;
	}
}