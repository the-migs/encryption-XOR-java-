package pacoteCriptoAndDescripto;

public class Hash {
    static String metodoHash(String senhaUsuario, String senhaPadrao){
        int tamanhoMaximo = Math.max(senhaUsuario.length(), senhaPadrao.length());
        int[] container = new int[tamanhoMaximo];
        char[] caracter = new char[tamanhoMaximo];
        for(int i = 0; i < tamanhoMaximo; i++){
            //conta para evitar erro de valor maior que o outro e para mais aleatoriedade no resultado

            int indexUsuario = i % senhaUsuario.length();
            int indexPadrao = i % senhaPadrao.length();

            container[i] = senhaUsuario.charAt(indexUsuario) ^ senhaPadrao.charAt(indexPadrao);
        }
        for(int o = 0; o < container.length; o++){
            container[o] = ((((container[o] * 7680) / 10) - 100) ^ ((container[o] * 17) % 256));
            container[o] = ((container[o] << 2) + 5) % 65536;;
            container[o] = 32 + (container[o] % 95);

            caracter[o] = (char) container[o];
        }
        String resultado = new String(caracter);
        return resultado;   
    }
}