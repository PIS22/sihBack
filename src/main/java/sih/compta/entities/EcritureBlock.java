package sih.compta.entities;

import java.util.List;

import sih.securite.entities.Utilisateur;

public class EcritureBlock {
    public Ecriture e;
    public List<CompteEcriture> lines;
    Utilisateur use;

    public EcritureBlock(Ecriture e, List<CompteEcriture> lines) {
        this.e = e;
        this.lines = lines;
    }

    public Ecriture getE() {
        return e;
    }

    public void setE(Ecriture e) {
        this.e = e;
    }

    public List<CompteEcriture> getLines() {
        return lines;
    }

    public void setLines(List<CompteEcriture> lines) {
        this.lines = lines;
    }
}
