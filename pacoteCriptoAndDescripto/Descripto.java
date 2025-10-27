package pacoteCriptoAndDescripto;
import java.util.Arrays;
import java.util.Scanner;

public class Descripto {

    public static StringBuilder metodoDescripto(){
        Scanner scA = new Scanner(System.in);
        System.out.println("Digite o valor criptografado: \n-> Sempre coloque espaço entre os numeros!");
        String scannerTexto = scA.nextLine();
        System.out.println();

        String [] processo = scannerTexto.split(" ");
        int[] criptografado = Arrays.stream(processo).mapToInt(Integer::parseInt).toArray();

        System.out.println("Digite a senha: \n");
        String scannerSenha = scA.nextLine();
        scannerSenha += Principal.pepper;

        String[] senhas = {"Kp$3!mX#8zL&v9@qW2%cB*n5+Rt6FgHj","X8#k!pL$9@mQ*v2&zRn5%cB+wSd6FgHj",scannerSenha};
        System.out.println();

        StringBuilder resultadoDescripto = new StringBuilder();
        for(String senha: senhas){
            for(int i = 0, d = 0; i < processo.length; i++, d++){
                char[] senhaCharArray = senha.toCharArray();
                if(d == senha.length()){
                    d = 0;
                }
                criptografado[i] = (char)(criptografado[i] ^ senhaCharArray[d]);
            }
        }
        for(int num : criptografado){resultadoDescripto.append((char) num);}
        scA.close();
        return resultadoDescripto;
    }
}

