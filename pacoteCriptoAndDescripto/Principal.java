package pacoteCriptoAndDescripto;
import java.util.Scanner;

public class Principal {
    static String pepper = "OrAnGotAngO_01%4$#@(*&^:";

    static StringBuilder metodoCripto(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a senha: ");
        String senhaScanner = sc.nextLine();
        senhaScanner += pepper;
        String[] senhas = {senhaScanner,"X8#k!pL$9@mQ*v2&zRn5%cB+wSd6FgHj","Kp$3!mX#8zL&v9@qW2%cB*n5+Rt6FgHj"};    
        System.out.println();
        
        System.out.println("Digite o texto a ser criptografado: ");
        String valorDescriptografado = sc.nextLine();
        System.out.println();
        
        char[] textoChar = valorDescriptografado.toCharArray();

        StringBuilder resultado = new StringBuilder();
        for(String senha : senhas){
            for(int i = 0, d = 0; i < valorDescriptografado.length(); i++, d++){
                char[] senhaChar = senha.toCharArray(); 
                if(d == senha.length()){
                    d = 0;
                }
                textoChar[i] = (char)(textoChar[i] ^ senhaChar[d]);
            }
        }
        sc.close(); 
        for(int num : textoChar){resultado.append(num).append(" ");}
        return resultado;
    }
    public static void main(String[]args){
        Scanner scB = new Scanner(System.in);
        
        System.out.println("\nDeseja criptografar(0) ou descriptografar(1)? - digite 0 ou 1.");
        String resposta = scB.nextLine();
        System.out.println();
        switch (resposta) {
            case "0":
                System.out.println("-".repeat(100) + "\nvalor criptografado: " + metodoCripto());
                System.out.println("-".repeat(100));
                break;
            case "1":
                System.out.println("-".repeat(100) + "\nvalor descriptografado: " +Descripto.metodoDescripto());
                System.out.println("-".repeat(100));
                break;
            default:
                System.out.println("Escolha incorreta!");
                break;
        }
        scB.close();
    }
}

