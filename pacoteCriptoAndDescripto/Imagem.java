package pacoteCriptoAndDescripto;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public class Imagem {
    public static void metodoCryptoImagem() {
        // vai pedir a imagem
        JFileChooser fileChooser = new JFileChooser();
        // guarda o valor numero que representa a escolha do usuario (0 - abriu | 1 - cancelou)
        int resultado = fileChooser.showOpenDialog(null);

        // vai guardar as informacoes do arquivo selecionado(caminho, nome, tipo ...etc)
        File arquivoImagem = null;

        // verifica se o usuario abriu algo (0 = APPROVE_OPTION)
        if (resultado == JFileChooser.APPROVE_OPTION) {
            arquivoImagem = fileChooser.getSelectedFile();

            try {  
                // vai ler os bytes e salvar
                byte[] bytesDaImagem = Files.readAllBytes(arquivoImagem.toPath());
 
                String caminhoOriginal = arquivoImagem.getAbsolutePath();
                String novoCaminho = caminhoOriginal.replace(".jpg", ".txt")
                                            .replace(".png", ".txt")
                                            .replace(".jpeg", ".txt");
                File arquivoTxt = new File(novoCaminho);

                // converte para String ao mesmo tempo que converte os bytes em caracteres com o charset ISO-8859-1 (Latin-1)
                String textoIlegivel = new String(metodoCriptoBytesImagem(bytesDaImagem), "ISO-8859-1");
                //renomeia para .txt
                arquivoImagem.renameTo(arquivoTxt);
                //salva no lugar da imagem
                Files.writeString(arquivoTxt.toPath(), textoIlegivel, Charset.forName("ISO-8859-1"));
                
                
            } catch (IOException e) {  // tratamento de erro
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo: " + e.getMessage());
            }
        }
    }

static byte[] metodoCriptoBytesImagem(byte[] bytesDaImagem){

        System.out.println("Digite a senha: ");
        String senhaScanner = Principal.scGlobal.nextLine();

        senhaScanner += Principal.pepper;        
        String[] senhas = {senhaScanner,
                        Hash.metodoHash(senhaScanner,"X8#k!pL$9@mQ*v2&zRn5%cB+wSd6FgHj"),
                        Hash.metodoHash(senhaScanner,"Kp$3!mX#8zL&v9@qW2%cB*n5+Rt6FgHj")};    
        System.out.println();
        for(String senha : senhas){
            for(int i = 0; i < bytesDaImagem.length; i++){
                char[] senhaChar = senha.toCharArray(); 
                int d = i % senha.length();
                bytesDaImagem[i] = (byte)(bytesDaImagem[i] ^ senhaChar[d]);
            }
        }
        return bytesDaImagem;
    }

public static void metodoDescriptoImagem() {
    // Pedir o arquivo .txt
    JFileChooser fileChooser = new JFileChooser();
    int resultado = fileChooser.showOpenDialog(null);

    if (resultado == JFileChooser.APPROVE_OPTION) {
        File arquivoTxt = fileChooser.getSelectedFile();
        
        try {
            // Ler o texto criptografado
            String textoCripto = Files.readString(arquivoTxt.toPath(), Charset.forName("ISO-8859-1"));
            
            // Converter texto para bytes
            byte[] bytesCripto = textoCripto.getBytes("ISO-8859-1");
            
            // Descriptografar 
            byte[] bytesImagem = metodoCriptoBytesImagem(bytesCripto);
            
            // converter de volta para imagem
            String caminhoImagem = arquivoTxt.getAbsolutePath().replace(".txt", ".jpg");
            File arquivoImagem = new File(caminhoImagem);
            
            // renomear .txt pra jpg e escrever bytes da imagem
            Files.move(arquivoTxt.toPath(), arquivoImagem.toPath());
            Files.write(arquivoImagem.toPath(), bytesImagem);
            
        } catch (Exception e) {
            e.printStackTrace();           
        }
        }
    }
}