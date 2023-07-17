package compiladores.t3;

import java.io.File;
import java.io.PrintWriter;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import java.util.Iterator;

public class Principal {
    public static void main(String[] args) {
        try (PrintWriter p = new PrintWriter(new File(args[1]))) {
            // Inicia o fluxo de caracteres do arquivo e inicia o analisador lexico com ele
            CharStream cs = CharStreams.fromFileName(args[0]);// entrada
            AnalisadorLexer lexer = new AnalisadorLexer(c);

            // A stream de tokens e o analisador parser são iniciados
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            AnalisadorParser parser = new AnalisadorParser(tokens);

            // A árvore de execução é criada com o progrma do parser sendo rodado
            AnalisadorParser.ProgramaContext arvore = parser.programa();

            // Analisador semântico é criado e o programa visita os nós da árvore criada
            AnalisadorSemantico as = new AnalisadorSemantico();
            as.visitPrograma(arvore);

            // Iterator é usado para saber caso encontre algum erro semântico
            Iterator<String> iterator = SemanticoUtils.errosSemanticos.iterator();
            while (iterator.hasNext()) {
                String err = iterator.next();
                p.println(err);
            }
            
            // Programa é finalizado
            p.println("Fim da compilacao");
            p.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
