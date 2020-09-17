package exo5;

import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

public class Etudiant {
	
	String nom;
	Set<Note> notes = new LinkedHashSet<>();
	
	public Etudiant(String nom) {
		this.nom = nom;
	}

	public void setNotes(Matiere matiere, double finalTestValue, double practicalWorkValue) {
		Note g = new Note(matiere, finalTestValue, practicalWorkValue);
		notes.add(g);
	}

	public String getReleveDeNotes() {
		StringBuilder releveDeNotes = new StringBuilder();

		releveDeNotes.append("Nom : ").append(nom).append("\n");
		releveDeNotes.append(String.format("%-14s", "\tMatière"));
		releveDeNotes.append(String.format("%-16s", "Note Test"));
		releveDeNotes.append(String.format("%-15s", "Note TP"));
		releveDeNotes.append(String.format("%s", "Moyenne\n"));
		releveDeNotes.append(String.format("%-15s", "  -----------"));
		releveDeNotes.append(String.format("%-16s", "--------------"));
		releveDeNotes.append(String.format("%-15s", "-------------"));
		releveDeNotes.append("------------\n");

		int credits = 0;
		double moyenneGenerale = 0.0;

		for(Note g : notes) {
			releveDeNotes.append("\t").append(String.format("%-15s",g.getMatiere().getNom()));
			releveDeNotes.append(String.format("%-15s",g.getNoteTestFinal()));
			releveDeNotes.append(String.format("%-15s",g.getNoteTravauxPratiques()));
			
			double moyenne = 0;
			switch (g.getMatiere().getDiscipline()) {
				case Sport :
					moyenne = 0.15*g.getNoteTestFinal() + 0.85*g.getNoteTravauxPratiques();
					break;
				case Langues:
					moyenne = 0.25*g.getNoteTestFinal() + 0.75*g.getNoteTravauxPratiques();
					break;
				case Informatique:
					moyenne = (g.getNoteTestFinal()+ g.getNoteTravauxPratiques())/2;
					break;
			}
			releveDeNotes.append(moyenne).append("\n");
			
			moyenneGenerale += moyenne;
			if ( moyenne > 10 )
				credits += g.getMatiere().getCredits();
		}

		moyenneGenerale /= notes.size();
		releveDeNotes.append("\nMoyenne générale : ").append(String.format(Locale.US,"%.2f\n", moyenneGenerale));
		releveDeNotes.append("Crédits ECTS (European Credits Transfer Scale) obtenus : ").append(credits).append("\n");

		return releveDeNotes.toString();
	}

}
