package pacoteCriptoAndDescripto;
import java.util.Arrays;
import java.util.Scanner;

public class Descripto {

    public static StringBuilder metodoDescripto(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o valor criptografado: \n-> Sempre coloque espaço entre os numeros!");
        String scanner = sc.nextLine();
        System.out.println();

        String [] processo = scanner.split(" ");
        int[] criptografado = Arrays.stream(processo).mapToInt(Integer::parseInt).toArray();

        System.out.println("Digite a senha: \n");
        String scannerSenha = sc.nextLine();
        System.out.println();

        char[] senhaChar = scannerSenha.toCharArray();
        char[] compartimentoChar = new char[criptografado.length];

        StringBuilder resultadoDescripto = new StringBuilder();
        for(int i = 0, d = 0; i < criptografado.length; i++, d++){
            if(d == senhaChar.length){
                d = 0;
            }
            compartimentoChar[i] = (char)(criptografado[i] ^ senhaChar[d]);
        }
        for(char num : compartimentoChar){resultadoDescripto.append(num);}
        sc.close();
        return resultadoDescripto;
    }
}

