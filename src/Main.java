import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in );

            /** Ensiegnant liste */
            Ensignant dali = new Ensignant(1,"Dali"," Romdhani",2000,"Math");
            Ensignant imed = new Ensignant(2,"imed ","attia",500,"Info");
            Ensignant iheb = new Ensignant(3,"iheb", "guesmi",500,"Francais");

            List<Ensignant> EnsignantList = new ArrayList<>();
            EnsignantList.add(dali);
            EnsignantList.add(imed);
            EnsignantList.add(iheb);

            /** Etudiant liste*/
            Etudiant oubaid = new Etudiant(1,"oubaid"," aloui",4);
            Etudiant mahrez = new Etudiant(2,"mahrez"," hafsi",12);
            Etudiant louay = new Etudiant(3,"louay"," rdifi",5);

            List<Etudiant> EtudiantList = new ArrayList<>();
            EtudiantList.add(oubaid);
            EtudiantList.add(mahrez);
            EtudiantList.add(louay);

            /** Cours liste*/
            Cour Math = new Cour(1,"Math", "Td", "kedhe w kedhe", 2,4,2);
            Cour info = new Cour(2,"info", "Tp", "kedhe w kedhe", 1,12,1);
            Cour physique = new Cour(3,"Physique", "Exmain", "kedhe w kedhe", 3,12,3);
            List<Cour> CourList = new ArrayList<>();
            CourList.add(Math);
            CourList.add(physique);
            CourList.add(info);


            /** ecole */
            Ecole iset = new Ecole(EnsignantList,EtudiantList,CourList);
            Ensignant oussema = new Ensignant(6,"oussema","chatgui", 900,"phyisique");
            iset.addEnsignant(oussema);
            /** Affichage des Resultat */
            louay.FraisPayer(5000);
            mahrez.FraisPayer(6000);

            System.out.println("//////////// Gestion des salaire //////////");
            System.out.println("Iset Beja A gagner : "+ iset.getTotalAgrentgagne()+" DT");
            System.out.println("------Iset Beja a payer les salaire suivate----");
            for (Ensignant eng:EnsignantList
                 ) {
                eng.recevoirSalaire(eng.getSalaire());

                System.out.println("Iset Beja a dépensé la salaire à " + eng.getName()+" avec une salaire : "+eng.getSalaire()
                        +" et maintenant elle a  DT : " + iset.getTotalAgrentgagne());
            }
            System.out.println("Iset Beja A gagner : "+ iset.getTotalAgrentgagne()+" DT");
            System.out.println("Iset Beja A Epiuser  : "+ iset.getTotalArgentepuise()+" DT");

            /** afficher liste de cour pour un etudiant */
            System.out.println("/////////////////////");
            System.out.println(mahrez.getCourEtudiant());

            /** gestion des Exposer*/
            mahrez.EtudiantaddExposer("x+1=2",mahrez.nom,"1");
            mahrez.EtudiantaddExposer("f(x)=2x+1",mahrez.nom,"2");
            louay.EtudiantaddExposer("this.(nom)","math","2");

            System.out.println("//////////////////Exposer etudiant////////////////////////");
            mahrez.getExposeEtudiant();

            System.out.println("///////////////////////get cour Etuduant///////////////////");
            System.out.println(mahrez.getCourEtudiant());

            System.out.println("///////////////////////get cour Ensgnnnn///////////////////");
            System.out.println(imed.getCourEnsignant());

            System.out.println("///////////////////////get cour iset///////////////////");
            System.out.println(iset.getCours());

            while(true){
                System.out.println("----------------Login-------------------");
                System.out.println("voulez Login Ensignant(s) \n ou bien etudiant(e) \n ou bien Admin (a)  \n ou exit pour sortir" );
                try{
                String type = sc.nextLine();
                if(type.equals("exit")){
                    break;
                }
                else if (type.equals("e")) {
                    System.out.println("---------------id--------------------");
                    System.out.println("voulez Enter votre id");
                    int logininfo = sc.nextInt();
                        if (iset.verifyEtudiant(logininfo)) {
                            Etudiant etudiant = iset.getEtudiant(logininfo);
                            System.out.println(etudiant.toString());
                            while (true) {
                                System.out.println("----------------Choix-------------------");
                            System.out.println("pour afficher la liste des Cour type (c) \n ou envoyer un exposer type(e) \n ou pour afficher les Exposer de vous type(ae) \n  ou bien taper (p) pour payer votre frais \n  ou bien tapeer(ap) pour voir le frais a payer \n exit pour deconnecter");
                            String Response = sc.nextLine();
                            if (Response.equals("c")) {
                                System.out.println(etudiant.getCourEtudiant());
                            } else if (Response.equals("ae")) {
                                etudiant.getExposeEtudiant();
                            }else if(Response.equals("e")){
                                System.out.println("donner l'exposer");
                                String Exposer = sc.nextLine();
                                System.out.println("donner l'id de cour");
                                String idCour = sc.nextLine();
                                System.out.println("donner l'id de engs");
                                String idEnsgn = sc.nextLine();
                                etudiant.EtudiantaddExposer(Exposer, idCour, idEnsgn);
                            }else if (Response.equals("p")) {
                                System.out.println("Donner le frais a payer");
                                int Frais = sc.nextInt();
                                etudiant.FraisPayer(Frais);
                            }else if (Response.equals("ap")) {
                                System.out.println("Vous avez payer : " +etudiant.getFraisPayer() +"DT et il vous reste que " + etudiant.getfraisapayer()+"DT \n ");
                            }
                            else if (Response.equals("exit")) {
                                break;
                            }
                            }
                        }
                        else{
                            System.out.println("wrong Id");
                            continue;
                        }
                }
                else if (type.equals("s")) {
                    System.out.println("---------------id--------------------");
                    System.out.println("voulez Enter votre id");
                    int logininfo = sc.nextInt();
                    if (iset.verifyEnsg(logininfo)) {
                        Ensignant ensignant = iset.getEnsg(logininfo);
                        System.out.println(ensignant);
                        while (true) {
                            System.out.println("----------------Choix-------------------");

                            System.out.println("pour afficher la liste des Cour type (c) \n ou Repondre a un exposer type(r) \n ou pour afficher les Exposer des Etudiants type(ae) \n  ou bien tapeer(as) pour voir votre salaire \n exit pour deconnecter");
                            String Response = sc.nextLine();
                            if (Response.equals("c")) {
                                System.out.println(ensignant.getCourEnsignant());
                            }else if(Response.equals("r")){
                                System.out.println("donner votre reponse");
                                String Exposer = sc.nextLine();
                                System.out.println("donner id de Exposer");
                                int idExp = sc.nextInt();
                                ensignant.RepondreauExposer(idExp,Exposer);
                            }else if(Response.equals("as")){
                                System.out.println(ensignant.getSalaire());
                            }else if(Response.equals("ae")){
                            ensignant.getExposerEtudiant();
                            }
                            else if (Response.equals("exit")) {
                                break;
                            }
            }

        }
}
                else if (type.equals("a")){
                    while (true) {
                        System.out.println("----------------Choix-------------------");

                        System.out.println("pour afficher la liste des Cour type (c) \n ou ajouter un etudiant(ae)/Ensignant (as) \n  ou afficher les Ensignant (afs) / etudiant(afe) \n ou supprimer les Ensignant (es) / etudiant(ee) \n ou bien tapeer(ap) pour voir le frais \n ou pour doner a Ensignant son salaire(ds)\n exit pour deconnecter");
                        String Response = sc.nextLine();
                        if (Response.equals("c")) {
                            System.out.println(iset.getCours());
                        }
                        else if (Response.equals("ae")) {

                            System.out.println("donner Le id du Etudiant");
                            int id = Integer.parseInt(sc.nextLine());
                            System.out.println("donner Le nom du Etudiant");
                            String nom = sc.nextLine();
                            System.out.println("donner Le prenom du Etudiant");
                            String prenom = sc.nextLine();
                            System.out.println("donner Le grade du Etudiant");
                            int grade = sc.nextInt();
                            Etudiant etd = new Etudiant(id,nom,prenom,grade);
                            iset.addEtudiant(etd);

                        }
                        else if (Response.equals("as")) {
                            System.out.println("donner Le id du Ensignant");
                            int id = Integer.parseInt(sc.nextLine());
                            System.out.println("donner Le nom du Ensignant");
                            String nom = sc.nextLine();
                            System.out.println("donner Le prenom du Ensignant");
                            String prenom = sc.nextLine();
                            System.out.println("donner Le matiere du Ensignant");
                            String matiere = sc.nextLine();
                            System.out.println("donner Le salaire du Ensignant");
                            int salaire = sc.nextInt();
                            Ensignant etd = new Ensignant(id,nom,prenom,salaire,matiere);
                            iset.addEnsignant(etd);
                        }
                        else if (Response.equals("afe")) {
                            System.out.println(iset.getEtudiants());
                        }
                        else if (Response.equals("afs")) {
                            System.out.println(    iset.getEnsignants());
                        }
                        else if (Response.equals("ee")) {
                            System.out.println("donner Le id du Etudiant que tu veut efaacer");
                            int id = sc.nextInt();
                            iset.EffaceEtudiant(iset.getEtudiant(id));
                        }
                        else if (Response.equals("ap")) {
                            System.out.println(iset.getTotalAgrentgagne());
                        }
                        else if (Response.equals("ds")) {
                            System.out.println("donner Le id du Ensignant");
                            int id = sc.nextInt();
                            System.out.println("donner Le salaire du Ensignant");
                            int salaire = sc.nextInt();
                            iset.getEnsg(id).recevoirSalaire(salaire);
                        }
                        else if (Response.equals("exit")) {
                            break;
                        }
                    }
                }
                }catch(Exception e){
                    System.out.println("erruer dans linput: "+e);}
                    continue;
                }










        }
}


