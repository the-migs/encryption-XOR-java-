package pacoteCriptoAndDescripto;
import java.util.Arrays;

public class Descripto {

    public static StringBuilder metodoDescripto(){
        System.out.println("Digite o valor criptografado: \n-> Sempre coloque espaço entre os numeros!");
        String scannerTexto = Principal.scGlobal.nextLine();
        System.out.println();

        String [] processo = scannerTexto.split(" ");
        int[] criptografado = Arrays.stream(processo).mapToInt(Integer::parseInt).toArray();

        System.out.println("Digite a senha: ");
        String scannerSenha = Principal.scGlobal.nextLine();
        System.out.println();
        scannerSenha += Principal.pepper;

        String[] senhas = {Hash.metodoHash(scannerSenha,"Kp$3!mX#8zL&v9@qW2%cB*n5+Rt6FgHj"),
                           Hash.metodoHash(scannerSenha,"X8#k!pL$9@mQ*v2&zRn5%cB+wSd6FgHj"),
                           scannerSenha};

        StringBuilder resultadoDescripto = new StringBuilder();
        for(String senha: senhas){
            for(int i = 0; i < processo.length; i++){
                char[] senhaCharArray = senha.toCharArray();
                int d = i % senha.length();
                criptografado[i] = (char)(criptografado[i] ^ senhaCharArray[d]);
            }
        }
        for(int num : criptografado){resultadoDescripto.append((char) num);}
        return resultadoDescripto;
    }
}