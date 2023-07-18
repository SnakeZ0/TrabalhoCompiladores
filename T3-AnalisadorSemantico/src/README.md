# Trabalho 3 - Analisador Semântico

Trabalho da disciplina de Compiladores 2023/1

Professor:    Daniel Lucrédio.

Estudantes:   

    Gabriel Mansano Pires, RA: 790951

    Jonathan Braian Dias Vaz, RA: 790870

    Pedro Freire Baleeiro, RA: 790984
              
Descrição:    Desenvolvimento de um Analisador Semântico na linguagem JAVA utilizando Antlr4.

Dependências: JDK 17 (1.7) - Maven 4.0.0 - Antlr4 4.11.1

## Passos para Compilar e Executar o Analisador com o Corretor e Casos de Teste disponibilizados
1) Acesse o código Principal.java na seguinte pasta "analisadorsemantico/main/java/br/ufscar/dc/compiladores/analisador/lexico/Principal.java";

2) Utilize o comando a seguir para criar um pacote distribuível (formato ".jar");

```
mvn package
```

3) O pacote "semantico-1.0-jar-with-dependencies.jar" será criado e ficará disponível na pasta "analisadorsemantico/target/lexico-1.0-jar-with-dependencies.jar";
 
4) Acesse novamente o terminal e execute o comando a seguir substituindo os campos de "ARG*" com os arquivos e dados indicados;
  
```
java -jar <ARG1> "java -jar <ARG2>" gcc <ARG3> <ARG4> "<ARG5>" t1
```

"ARG1" -> Localização completa do arquivo de corretor (compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar). Como exemplo abaixo:

```
C:\Compiladores_2023s01\corretor\compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar
```

"ARG2" -> Localização completa do .jar de execução que se encontra na pasta "target" (analisador-lexico-1.0-SNAPSHOT-jar-with-dependencies.jar). Como exemplo abaixo: 

```
C:\Compiladores_2023s01\Trabalho1Compiladores\analisadorlexico\target\analisador-semantico-1.0-SNAPSHOT-jar-with-dependencies.jar
```

"ARG3" -> Localização completa onde sairám os arquivos resultantes da execução (temp). Como exemplo abaixo:

```
C:\Compiladores_2023s01\temp
```

"ARG4" -> Localização completa da pasta de Casos de Testes (casos-de-teste). Como exemplo abaixo:

```
C:\Compiladores_2023s01\casos-de-teste
```

"ARG5" -> RA's dos membros do grupo (RA1, RA2, RA3). Como exemplo abaixo:

```
790951, 790870, 790984
```

5) O código de execução completo seguirá o exemplo abaixo:

```
java -jar C:\Compiladores_2023s01\corretor\compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar "java -jar C:\Compiladores_2023s01\Trabalho1Compiladores\analisadorlexico\target\analisador-lexico-1.0-SNAPSHOT-jar-with-dependencies.jar" gcc C:\Compiladores_2023s01\temp C:\Compiladores_2023s01\casos-de-teste "790951, 790870, 790984" t1
```

6) Caso o arquivo de entrada seja válido o sistema retornará um arquivo de saída correto.

## Passos para Compilar e Executar o Analisador com arquivos externos aos Casos de Teste
1) Acesse o código Principal.java na seguinte pasta "analisadorsemantico/main/java/br/ufscar/dc/compiladores/analisador/semantico/Principal.java";

2) Utilize o comando a seguir para criar um pacote distribuível (formato ".jar");

```
mvn package
```

3) O pacote "lexico-1.0-jar-with-dependencies.jar" será criado e ficará disponível na pasta "analisadorsemantico/target/semantico-1.0-jar-with-dependencies.jar";
 
4) Acesse novamente o terminal e execute o comando a seguir substituindo os campos de e com os arquivos de entrada e saída respectivamente;

```
java -jar  lexico-1.0-jar-with-dependencies.jar <input> <output>
```

<OBS:> Se necessário coloque o caminho completo do .jar para execução (C:\Compiladores_2023s01\Trabalho1Compiladores\analisadorsemantico\target\analisador-semantico-1.0-SNAPSHOT-jar-with-dependencies.jar).

5) Caso o arquivo de entrada seja válido o sistema retornará um arquivo de saída correto.
