package pacoteCriptoAndDescripto;
import java.util.Scanner;

public class Principal {
    static char[] senhaChar;
    static char[] criptografado;
    
    static StringBuilder metodoCripto(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a senha: ");
        String senha = sc.nextLine();
        System.out.println();

        senhaChar = senha.toCharArray();
        
        System.out.println("Digite o texto a ser criptografado: ");
        String valorDescriptografado = sc.nextLine();
        System.out.println();
        
        char[] textoChar = valorDescriptografado.toCharArray();

        criptografado = new char[valorDescriptografado.length()];
        StringBuilder resultado = new StringBuilder();

        for(int i = 0, d = 0; i < valorDescriptografado.length(); i++, d++){
            if(d == senha.length()){
                d = 0;
            }
            criptografado[i] = (char)(textoChar[i] ^ senhaChar[d]);
        }
        for(int num : criptografado){resultado.append(num).append(" ");}
        sc.close();
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

