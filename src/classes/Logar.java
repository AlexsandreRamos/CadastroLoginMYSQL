package classes;

import GetSet.LoginGetSet;
import DAO.LoginDAO;
import java.util.Scanner;

public class Logar {

    public void login() {
        Scanner teclado = new Scanner(System.in);
       
        LoginGetSet LGS = new LoginGetSet();
        LoginDAO LoginDAO = new LoginDAO();

        while (LoginDAO.verificado == false) {

            System.out.println("\n\n-------MENU LOGIN-------"
                    + "\nDigite o nome do usuario"
                    + "\n(*) voltar"
                    + "\n\nDIGITE AQUI: ");

            LGS.setLogin(teclado.nextLine());
            if (!LGS.getLogin().equals("*")) {
                System.out.println("\n\nDigite a senha do usuario: ");
                LGS.setSenha(teclado.nextLine());

                LoginDAO.verificar(LGS);
                if (LoginDAO.verificado == false) {
                    System.out.println("Login ou Senha incorreto! Tente novamente.");
                }

            } else {
                LoginDAO.verificado = true;
            }

        }

    }
}
