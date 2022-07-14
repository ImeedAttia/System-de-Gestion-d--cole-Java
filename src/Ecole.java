import java.util.ArrayList;
import java.util.List;

public class Ecole {
    private List<Ensignant> Ensignants;
    private List<Etudiant> Etudiants;
    static List<Cour> Cours;
    private static int  totalAgrentgagne;
    private static int totalArgentepuise;
    static List<Cour>  CoursEtudiant = new ArrayList<>();
    static List<Cour>  CoursEnsignant = new ArrayList<>();

    public Ecole(List<Ensignant> Ensignants, List<Etudiant> Etudiants,List<Cour> Cours) {
        this.Ensignants = Ensignants;
        this.Etudiants = Etudiants;
        this.Cours= Cours;
        totalAgrentgagne=0;
        totalArgentepuise=0;

    }
    /** Gestion des Cours */
    boolean EffaceCour(Cour Cour){return  Cours.remove(Cour);}
    public List<Cour> getCours() {
        return Cours;
    }
    public void addCour(Cour Cour) {
        Cours.add(Cour);
    }
    public static List<Cour> getCourEtudiant(int a){
        CoursEtudiant.clear();
        CoursEtudiant.addAll(Cours);
        int i = 0;
        while(i < CoursEtudiant.size()){
            if (CoursEtudiant.get(i).grade  != a ) {
                CoursEtudiant.remove(i);
                if (i == 0) {
                    continue;
                }else i-=1;
            } else i++;
        }
        return CoursEtudiant;
    }
    public static List<Cour> getCourEnsignant(int idEnsg){
        CoursEnsignant.clear();
        CoursEnsignant.addAll(Cours);
        int i = 0;
        while(i < CoursEnsignant.size()){
            if (CoursEnsignant.get(i).idEnseng  != idEnsg ) {
                CoursEnsignant.remove(i);
                if (i == 0) {
                    continue;
                }else i-=1;
            } else i++;
        }
        return CoursEnsignant;
    }


    /** gestion des Ensignants */
    public List<Ensignant> getEnsignants() {
        return Ensignants;
    }
    public void addEnsignant(Ensignant Ensignant){Ensignants.add(Ensignant);}
    boolean EffaceEnsignant(Ensignant Ensignant){return  Ensignants.remove(Ensignant);}

    /** gestion des Etudiants */
    public Etudiant getEtudiant(int idE) {
        Etudiant et = new Etudiant();
        for (Etudiant e: Etudiants
             ) {
            if (e.id == idE ) {
                et = e;
                break;
            }else et= null;
        }return et;
    }
    public Ensignant getEnsg(int idE) {
        Ensignant ensg = new Ensignant();
        for (Ensignant e: Ensignants
        ) {
            if (e.getId() == idE ) {
                ensg = e;
                break;
            }else ensg= null;
        }return ensg;
    }
    public boolean verifyEtudiant(int idEt){
        boolean verify = false;
        for (int i = 0; i < Etudiants.size(); i++) {
            if (Etudiants.get(i).getId() == idEt ) {
                verify = true;
                break;
        }}


        return  verify;
    }
    public boolean verifyEnsg(int idEt){
        boolean verify = false;
        for (int i = 0; i < Ensignants.size(); i++) {
            if (Ensignants.get(i).getId() == idEt ) {
                verify = true;
                break;
            }}


        return  verify;
    }
    public List<Etudiant> getEtudiants() {
        return Etudiants;
    }
    public void addEtudiant(Etudiant Etudiant) {
        Etudiants.add(Etudiant);
    }
    boolean EffaceEtudiant(Etudiant Etudiant){return Etudiants.remove(Etudiant);}

    /** Getsion des salaire */
    public static void miseTotalAgrentgagne(int Agrentgagne){totalAgrentgagne += Agrentgagne;}
    public static void misetotalArgentepuise(int Argentepuise){totalAgrentgagne -= Argentepuise;totalArgentepuise += Argentepuise;}
    public static int getTotalAgrentgagne(){return totalAgrentgagne;}
    public static int getTotalArgentepuise(){return totalArgentepuise;}
}
