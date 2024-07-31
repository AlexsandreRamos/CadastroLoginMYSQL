package classes;

import GetSet.CadastroGetSet;
import DAO.CadastroDAO;
import java.util.Scanner;

public class Cadastrar {
    // ETAPA 1: CADASTRAR O NOME DE USUARIO

    public void cadastroLogin() {
        // SCANNER
        Scanner teclado = new Scanner(System.in);

        // DECLARANDO CLASSES
        CadastroGetSet CGS = new CadastroGetSet();
        CadastroDAO cadastrarMYSQL = new CadastroDAO();

        // WHILE DE VERIFICAÇÃO CASO TENHA UM NOME DE USUARIO JA EXISTENTE
        while (cadastrarMYSQL.loginExistente == true) {

            // JA SETADO COMO TRUE PARA ENTRAR NO WHILE
            if (cadastrarMYSQL.loginExistente == true) {
                // TRANSORMA EM FALSE CASO SEJA TRUE
                cadastrarMYSQL.loginExistente = false;
            }

            System.out.println("-------MENU CADASTRO-------"
                    + "\n\n\nDigite o nome de Usuario"
                    + "\n(*) voltar "
                    + "\n\nDIGITE AQUI:");
            // DIGITA O NOME DE USUARIO
            CGS.setLogin(teclado.nextLine());
            // SE GETLOGIN DIFERENTE DE *
            if (!CGS.getLogin().equals("*")) {
                // FAZ UMA VERIFICAÇÃO NO BANCO DE DADOS CASO TENHA O "LOGINEXISTENTE" SE TORNA TRUE NOVAMENTE MANTENDO O LOOP
                cadastrarMYSQL.verUserExist(CGS);
                // AVANÇA A ETAPA
                cadastroSenha(CGS);
            }else{
                
            }
        }

    }

    // ETAPA 2: CADASTRAR A SENHA DO USUARIO
    public void cadastroSenha(CadastroGetSet CGS) {
        // SCANNER
        Scanner teclado = new Scanner(System.in);

        System.out.println("\n\nDigite a Senha desejada: ");

        // SETA A SENHA 
        CGS.setSenha(teclado.nextLine());

        // CONDIÇÃO PARA ENTRAR NO WHILE
        String senhaConf = "";

        // WHILE(CASO A SENHA ESCRITA ANTERIOR FOR DIFERENTE DA PROXIMA SENHA ESCRITA MANTEM O LOOP)
        while (!CGS.getSenha().equals(senhaConf)) {

            System.out.println("\n\nConfirme a sua Senha: ");
            // ESCREVENDO A SENHA NOVAMENTE
            senhaConf = teclado.nextLine();
            if (!CGS.getSenha().equals(senhaConf)) {
                // CASO SEJA DIFERENTE DA PRIMEIRA
                System.out.println("\nSenha incorreta! Tente novamente.");

            }
        }

        // AVANÇANDO DE ETAPA
        cadastroDados(CGS);
    }

    // ETAPA 3 FINAL: CADASTRAR OS DADOS DO USUARIO
    public void cadastroDados(CadastroGetSet CGS) {
        // DECLARANDO A CLASSE DAO
        CadastroDAO cadastrarMYSQL = new CadastroDAO();

        // SCANNERS
        Scanner teclado = new Scanner(System.in);
        Scanner tecladoInt = new Scanner(System.in);

        System.out.println("Conta criada com sucesso!"
                + "\nAgora é hora de cadastrar seus dados!"
                + "\n\nDigite seu nome completo: ");

        // SETANDO O NOME COMPLETO
        CGS.setNome(teclado.nextLine());

        System.out.println("\n\nDigite sua data de nascimento: "
                + "\nexemplo(12042007)");
        // SETANDO DATA DE NASCIMENTO
        CGS.setDataNascimento(tecladoInt.nextInt());

        System.out.println("\n\nDigite seu telefone: "
                + "\nexemplo(51912341234)");
        // SETANDO TELEFONE
        CGS.setTelefone(tecladoInt.nextDouble());

        // ENVIANDO TODOS OS DADOS DO GET SET PARA O MYSQL
        cadastrarMYSQL.cadastrar(CGS);

    }
}
