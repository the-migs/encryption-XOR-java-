package pacoteCriptoAndDescripto;
import java.util.Scanner;

public class Principal {
    static final Scanner scGlobal = new Scanner(System.in);
    static String pepper = "ThE_k4R4LHOO0O0O_PVnh&tARAnGotAngO_01%4$#@(*&^:";

    static StringBuilder metodoCriptoParaTexto(){
        System.out.println("Digite o texto a ser criptografado: ");
        String valorDescriptografado = scGlobal.nextLine();
        System.out.println();
        
        char[] textoChar = valorDescriptografado.toCharArray();

        System.out.println("Digite a senha: ");
        String senhaScanner = scGlobal.nextLine();
        senhaScanner += pepper;
        String[] senhas = {senhaScanner,
                        Hash.metodoHash(senhaScanner,"X8#k!pL$9@mQ*v2&zRn5%cB+wSd6FgHj"),
                        Hash.metodoHash(senhaScanner,"Kp$3!mX#8zL&v9@qW2%cB*n5+Rt6FgHj")};    
        System.out.println();
        
        StringBuilder resultado = new StringBuilder();
        for(String senha : senhas){
            for(int i = 0; i < valorDescriptografado.length(); i++){
                char[] senhaChar = senha.toCharArray(); 
                int d = i % senha.length();
                textoChar[i] = (char)(textoChar[i] ^ senhaChar[d]);
            }
        }
        for(int num : textoChar){resultado.append(num).append(" ");}
        return resultado;
    }
    public static void main(String[]args){
        String resposta = "";
        while(!resposta.toLowerCase().equals("kill")) {
            System.out.println("\nEscolha o que deseja fazer:\n" + "-".repeat(100));

            System.out.println("> Criptografar texto(0)\n"+
                                "\n> Descriptografar texto(1)\n" + 
                                "\n> Criptografar imagem(2)\n"+
                                "\n> Desriptografar imagem(3)\n"+
                                "\n> Sair(KILL)");
            System.out.println("-".repeat(100)+"\n-> digite 0, 1, 2, 3 ou KILL.");
            resposta = scGlobal.nextLine();
            System.out.println();
            switch (resposta) {
            case "0":
                System.out.println("-".repeat(100) + "\nvalor criptografado: " + metodoCriptoParaTexto());
                System.out.println("-".repeat(100));
                break;
            case "1":
                System.out.println("-".repeat(100) + "\nvalor descriptografado: " +Descripto.metodoDescripto());
                System.out.println("-".repeat(100));
                break;
            case "2":
                Imagem.metodoCryptoImagem();
                break;
            case "3":
                Imagem.metodoDescriptoImagem();
                break;
            case "kill":
            case "KILL":
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Escolha incorreta!");
                break;
            }
        }
    }
}