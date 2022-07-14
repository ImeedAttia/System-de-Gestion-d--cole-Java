public class Cour {
    int id;
    String nom;
    String type;
    String contenu;
    int chargeHoraire;
    int grade;
    int idEnseng;


    public Cour(int id,String nom,String type , String contenu,int chargeHoraire,int grade,int idEnseng){
        this.id= id;
        this.nom = nom;
        this.chargeHoraire=chargeHoraire;
        this.contenu=contenu;
        this.type=type;
        this.grade = grade;
        this.idEnseng=idEnseng;
    }


    @Override


    public String toString() {
        return "Cour{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", type='" + type + '\'' +
                ", contenu='" + contenu + '\'' +
                ", chargeHoraire=" + chargeHoraire +
                ", grade=" + grade +
                ", idEnseng=" + idEnseng +
                '}';
    }
}
