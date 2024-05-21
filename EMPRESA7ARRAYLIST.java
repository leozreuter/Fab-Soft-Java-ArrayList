package com.mycompany.empresa7arraylist;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class EMPRESA7ARRAYLIST {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Funcionario> meusFuncionarios = new ArrayList<Funcionario>();
        String usuario = System.getProperty("user.name");
        
        int escolha;
        int contadorFunc = 0;
        int max = 3;
        
        System.out.print("|Bem vindo "+usuario+", você está utilizando ArrayList|");
        
        do{
            try{
                System.out.print("""
                                 
                                 
                                 |------------- Menu -------------|
                                 1. Add Funcionário.
                                 2. Consulta Funcionário;
                                 3. Edit Funcionario;
                                 4. Excluir Funcionario;
                                 5. Sair.
                                 
                                 --> """);
                
                escolha = sc.nextInt();
                sc.nextLine(); //Limpa o buffer
                
                switch (escolha){
                    case 1 -> {
                        if(contadorFunc == max){
                            System.out.print("Você atingiu o limite de funcionarios cadastraos ("+max+")");
                            break;
                        }
                        System.out.print("Digite o nome do funcionario: ");
                        String nome = sc.next();
                        
                        System.out.println("Cargos possíveis:");
                        for (Cargo cargo : Cargo.values()) {
                            System.out.println("- " + cargo);
                        }

                        Cargo cargo = null;
                        while (true) {
                            System.out.print("Digite o cargo do funcionário: ");
                            String cargofunc = sc.next().toUpperCase();
                            try {
                                cargo = Cargo.valueOf(cargofunc);
                                break;  
                            } catch (IllegalArgumentException e) {
                                System.out.println("Cargo inválido! Tente novamente.");
                            }
                        }

                        System.out.print("Digite o salário do funcionário: ");
                        double salario = sc.nextDouble();

                        Funcionario novoFunc = new Funcionario(nome, cargo, salario);
                        meusFuncionarios.add(novoFunc);
                        contadorFunc++;
                    }

                    case 2 -> {
                        if (contadorFunc == 0) {
                            System.out.print("Nenhum funcionario cadastrado!");
                        }
                        else{
                            System.out.println("Funcionarios:");
                            for (int i = 0; i < contadorFunc; i++) {
                                System.out.println(meusFuncionarios.get(i).mostraFunc());
                            }
                        }
                    }
                    
                    case 3 -> {
                        if (contadorFunc == 0) {
                            System.out.print("Nenhum funcionario cadastrado!");
                        }
                        else{
                            System.out.println("Funcionarios:");
                            for (int i = 0; i < contadorFunc; i++) {
                                System.out.println(i+"- "+meusFuncionarios.get(i).mostraFunc());
                            }

                            System.out.print("\nDigite o indice do funcionario que deseja editar:\n-->");
                            int iconsulta = sc.nextInt();

                            while (iconsulta >= contadorFunc) {
                                System.out.println("Esse indice não existe!");
                                System.out.print("Digite o indice do funcionario que deseja editar:\n-->");
                                iconsulta = sc.nextInt();
                            }

                            int escolhaedit = 0;
                            do{
                                try {
                                    System.out.println("\nO que você deseja editar?");
                                    System.out.println("1- "+meusFuncionarios.get(iconsulta).getNome());
                                    System.out.println("2- "+meusFuncionarios.get(iconsulta).getCargo());
                                    System.out.println("3- "+meusFuncionarios.get(iconsulta).getSalario());
                                    System.out.println("4- Sair");
                                    System.out.print("-->");

                                    escolhaedit = sc.nextInt();

                                    switch (escolhaedit) {
                                        case 1:
                                            System.out.print("\nDigite o novo nome: ");
                                            String novonome = sc.next();
                                            meusFuncionarios.get(iconsulta).setNome(novonome);
                                            break;
                                        case 2:
                                            System.out.println("\nCargos possíveis:");
                                            for (Cargo cargoedit : Cargo.values()) {
                                                System.out.println("- " + cargoedit);
                                            }   
                                            Cargo cargonovo = null;
                                            while(true){
                                                System.out.print("Digite o novo cargo: ");
                                                String newcargo = sc.next().toUpperCase();
                                                try {
                                                    cargonovo = Cargo.valueOf(newcargo);
                                                    break;
                                                } catch (IllegalArgumentException e) {
                                                    System.out.println("Cargo inválido! Tente novamente.");
                                                }  
                                            }
                                            meusFuncionarios.get(iconsulta).setCargo(cargonovo);
                                            break;
                                        case 3:
                                            System.out.print("Digite o novo salario: ");
                                            Double novosalario = sc.nextDouble();
                                            meusFuncionarios.get(iconsulta).setSalario(novosalario);
                                            break;

                                        default:
                                            break;
                                    }

                                }catch (IllegalArgumentException e) {
                                    System.out.println("Cargo inválido! Tente novamente.");
                                }

                            }while (escolhaedit != 4);
                        }
                    }
                    
                    case 4 -> {
                            if (contadorFunc == 0) {
                                System.out.print("Nenhum funcionario cadastrado!");
                                break;
                            }else{
                                System.out.println("Funcionarios:");
                                for (int i = 0; i < contadorFunc; i++) {
                                    System.out.println(i+" - "+meusFuncionarios.get(i).mostraFunc());
                                }
                                System.out.print("\nQual funcionario deseja excluir? Responda com o indice: ");
                                int escolhaex = sc.nextInt();
                                while (escolhaex >= contadorFunc) {
                                    System.out.println("Esse indice não existe!");
                                    System.out.print("Digite o indice do funcionario que deseja editar:\n-->");
                                    escolhaex = sc.nextInt();
                                }
                                try{
                                    System.out.println("Voce tem certeza que deseja excluir o funcionario: --> "+meusFuncionarios.get(escolhaex).mostraFunc()+" ?");
                                    System.out.print("Se sim, digite 'S'\nSe não, digite 'N'\n-->");
                                    String crtz = sc.next();
                                    if ("S".equalsIgnoreCase(crtz)){
                                        meusFuncionarios.remove(escolhaex);
                                        System.out.print("Registro deletado com sucesso!");
                                        contadorFunc--;
                                    }else if ("N".equalsIgnoreCase(crtz)) {
                                        break;
                                    }
                                }catch (IllegalArgumentException e){
                                    System.out.print("ENTRADA INVALIDA! Insira novamente");
                                }
                            }
                        }
                    
                    case 5 ->{
                        System.out.print("Até mais!");
                        break;
                    }
                    
                    default ->{
                        System.out.println("Entrada inválida! Por favor, insira uma opcao valida.");
                        break;
                    }
                    }
                
                
            }catch (InputMismatchException e) {
                System.out.println("ENTRADA INVALIDA! Insira novamente");
                sc.next();
                escolha = -1;}
        }while(escolha != 5);
    }       
}