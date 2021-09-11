package exo5;

public class Matiere {
	
	enum Discipline { Sport, Langues, Informatique}

	String nom;
	Discipline discipline;
	int credit;
	
	public Matiere(String nom, Discipline discipline, int credit) {
		this.nom = nom;
		this.discipline = discipline;
		this.credit = credit;
	}

	public int getCredits() {
		return credit;
	}

	public Discipline getDiscipline() {
		return discipline;
	}

	public String getNom() {
		return nom;
	}
}
