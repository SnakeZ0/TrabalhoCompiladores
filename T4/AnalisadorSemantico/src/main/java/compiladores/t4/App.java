package compiladores.t4;
import java.io.File;
import java.io.PrintWriter;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class App 
{
    public static void main( String[] args )
    {
        try(PrintWriter p = new PrintWriter(new File(args[1]))) {//saida
            CharStream c = CharStreams.fromFileName(args[0]);//entrada
            AnalisadorLexer lex = new AnalisadorLexer(c);
            CommonTokenStream cs = new CommonTokenStream(lex); //conversão para token stream
            AnalisadorParser parser = new AnalisadorParser(cs);
            AnalisadorParser.ProgramaContext arvore = parser.programa();   
            AnalisadorSemantico as = new AnalisadorSemantico();  
            as.visitPrograma(arvore);
            for(String err: SemanticoUtils.errosSemanticos){
                p.println(err);
            }
            p.println("Fim da compilacao");
            p.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
