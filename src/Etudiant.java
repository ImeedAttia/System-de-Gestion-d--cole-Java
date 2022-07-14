import java.util.HashMap;
import java.util.List;

public class Etudiant extends Personne {
        
        int grade;
        int fraispayer;
        int fraistotal;
        public Etudiant(){}
        public Etudiant(int id, String nom,String prenom,int grade){
            super(id,nom,prenom);
            this.fraispayer=0;
            this.fraistotal=30000;
            this.id=id;
            this.nom=nom;
            this.prenom=prenom;
            this.grade=grade;
        }

        public void setGrade(int grade){
            this.grade=grade;
        }
        /** getter*/
        public int getId() {
            return id;
        }
        public String getName() {
            return nom;
        }
        public int getGrade() {
            return grade;
        }
        public int getfraistotal() {
            return fraistotal;
        }
        public int getfraisapayer(){
            return fraistotal-fraispayer;
        }
        /** Gestion des frais */
        public void FraisPayer(int frais){
            fraispayer += frais;
            Ecole.miseTotalAgrentgagne(fraispayer);
            System.out.println( this.nom +"  a payer un frais : " + fraispayer+" DT");
        }
        public int getFraisPayer(){
            return fraispayer;
    }

        @Override
        public String toString() {
            return "Etudiant{" +
                    super.toString() +
                    ", grade=" + grade +
                    ", fraispayer=" + fraispayer +
                    ", fraistotal=" + fraistotal +
                    '}';
        }
        /** Gestion des cours */
        public  List<Cour> getCourEtudiant(){
       return  Ecole.getCourEtudiant(this.grade);
    }
        /**travaill dispose des cour*/
        public  void EtudiantaddExposer(String Exposer,String idCour,String idEng){
                 /** have to be inisiziled ici car si on le met on top ou bien out of methode it will make an error of excution bcz the list will always add the last hashmap
                   il faut cree une nouvelle instance chasue fois que l'etudiant a entrer ces donner */
            HashMap<String,String> liste = new HashMap();
            /** fill the hashmap */
            liste.put("id Exposer :",Integer.toString(Ensignant.getExposer().size()));
            liste.put("id Ensignant", idEng);
            liste.put(" le nom du Cour ", idCour);
            liste.put("Nom Etudiant", this.nom+this.prenom);
            liste.put("L'exposer est", Exposer);
            liste.put("Reponse de Ensignnat", "");
            /** return the hashmap to the liste or add it to the liste */
            Ensignant.EtudiantaddExopser(liste);//fama Exception chouf int manaarch ay faza
        }

        public  void getExposeEtudiant(){
            for (HashMap Expose:
                    Ensignant.getExposer()) {
                if (Expose.containsValue(this.nom+this.prenom)) {
                    System.out.println(Expose);
                }
            }}
}




