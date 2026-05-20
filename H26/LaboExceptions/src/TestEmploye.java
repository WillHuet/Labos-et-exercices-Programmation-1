public class TestEmploye {


    public static void main(String[] args) {

        try {
            Employe e10 = new Employe("Daoust", "Mireille", 10, 78000);
            e10.setNomDeFamille("12");
            System.out.print(e10.getNomDeFamille());
        } catch (EmployeInvalideException e){
            System.out.println(e.getMessage());
        }

//        Employe e10 = new Employe("Daoust", "Mireille", 10, 78000);


//        Employe e1 = new Employe(null, "Roger", 2, 57000);
//        Employe e2 = new Employe("E", "Nancy", 5, 60000);
//        Employe e3 = new Employe("Lachance", null, 2, 53000);
//        Employe e4 = new Employe("St-Gervais", "R", 3, 55000);
//        Employe e5 = new Employe("Blais", "Richard", 0, 45000);
//        Employe e6 = new Employe("Daoust", "Mireille", 10, -1);
    }
}
