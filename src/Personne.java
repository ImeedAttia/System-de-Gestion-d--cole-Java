public  class Personne {
   protected int id;
    protected String nom;
    protected String prenom;
    public Personne(int id,String nom, String prenom){
        this.id = id;
        this.nom= nom;
        this.prenom= prenom;
    }
    public Personne() {
        this.id = 0;
        this.nom = "Foulen";
        this.prenom ="Ben Foulen";

    }

    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}
