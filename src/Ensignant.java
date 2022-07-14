import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Ensignant extends Personne{



       private int salaire;
       private int salaireGagner;
       private String matiere;
       private static List<HashMap> EtudiantExposer = new ArrayList<>();
        public Ensignant(){}
        public Ensignant(int id, String nom, String prenom, int salaire,String Matiere){
            super(id,nom,prenom);
            this.salaire=salaire;
            this.salaireGagner=0;
            this.matiere=Matiere;

        }

        /** Geeter */
        public int getId(){
            return id;
        }
        public String getName(){
            return nom;
        }
        public int getSalaire(){
            return  salaire;
        }
        /** Setter Pour salaire */
        public void setSalary(int salary){
            this.salaire=salary;
        }

        public void recevoirSalaire(int Salaire){
            salaireGagner += Salaire;
            Ecole.misetotalArgentepuise(Salaire);
            System.out.println(this.nom +"  a recevoir son salaire avec un montant : " +salaireGagner +"DT" );
        }

    @Override
    public String toString() {
        return "Ensignant{" +
                super.toString() +
                ", salaire=" + salaire +
                ", salaireGagner=" + salaireGagner +
                ", matiere='" + matiere + '\'' +
                '}';
    }
/** Exposer de etudiant  */
    public static void EtudiantaddExopser(HashMap Liste){EtudiantExposer.add(Liste);}
    public  void getExposerEtudiant(){
        for (HashMap Expose:
             EtudiantExposer) {
            if (Expose.get("id Ensignant").equals(Integer.toString(this.id))) {
                System.out.println(Expose);
            }
        }

    }
    public void RepondreauExposer(int IdExpose,String reponse){
            EtudiantExposer.get(IdExpose).replace("Reponse de Ensignnat",reponse);
    }
    /** cette methode static c'est pour envoyer les donner au class etudiant pour pouvoir gerer les exposer et afficher */
    public static List<HashMap> getExposer(){return EtudiantExposer;}
    public  List<Cour> getCourEnsignant(){
        return  Ecole.getCourEnsignant(this.id);
    }

}


