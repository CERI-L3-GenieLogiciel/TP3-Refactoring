package exo5;

public class Note {
	
	Matiere matiere;
	double noteTestFinal, noteTravauxPratiques;
	
	public Note(Matiere matiere, double noteTestFinal, double noteTravauxPratiques) {
		this.matiere = matiere;
		this.noteTestFinal = noteTestFinal;
		this.noteTravauxPratiques = noteTravauxPratiques;
	}

	public double getNoteTestFinal() {
		return noteTestFinal;
	}

	public double getNoteTravauxPratiques() {
		return noteTravauxPratiques;
	}

	public Matiere getMatiere() {
		return matiere;
	}

}
