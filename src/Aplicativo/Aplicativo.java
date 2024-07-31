package Aplicativo;


import classes.Cadastrar;
import classes.Logar;
import java.util.Scanner;

public class Aplicativo {
// MENU PRINCIPAL

    public void menuAplicativo() {
        Scanner teclado = new Scanner(System.in);
        String r = "";

        while (!r.equals("x")) {
            System.out.println("-------MENU PRINCIPAL-------"
                    + "\n\n\n(1) Login"
                    + "\n(2) Cadastrar"
                    + "\n(X) Fechar"
                    + "\n\nDIGITE AQUI: ");

            r = teclado.nextLine().toLowerCase();

            switch (r) {
                case "1":
                    
                    Logar l = new Logar();
                    l.login();
                    break;

                case "2":

                    
                    Cadastrar c = new Cadastrar();
                    c.cadastroLogin();

                    break;

                case "x":

                    break;
                default:
                    System.out.println("Valor Inválido!");
                    break;

            }

        }

    }

  

}
