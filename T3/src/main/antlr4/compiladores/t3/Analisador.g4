grammar Analisador;

programa: declaracoes 'algoritmo' corpo 'fim_algoritmo' EOF;

declaracoes: (decl_local_global)*; 

decl_local_global: declaracao_local | declaracao_global; 

declaracao_local: declaracao_variavel | declaracao_constante | declaracao_tipo; 

declaracao_variavel: 'declare' variavel;

declaracao_constante: 'constante' IDENT ':' tipo_basico '=' valor_constante;

declaracao_tipo: 'tipo' IDENT ':' tipo; 

variavel: identificador (',' identificador)* ':' tipo; 

identificador: IDENT ('.' IDENT)* dimensao;

dimensao: ('[' exp_aritmetica ']')*; 

tipo: registro | tipo_estendido;

tipo_basico: 'literal' | 'inteiro' | 'real' | 'logico'; 

tipo_basico_ident: tipo_basico | IDENT; 

tipo_estendido: '^'? tipo_basico_ident; 

valor_constante: CADEIA | NUM_INT | NUM_REAL | 'verdadeiro' | 'falso'; 

registro: 'registro' (variavel)* 'fim_registro'; 

declaracao_global: 'procedimento' IDENT '(' (parametros)? ')' (declaracao_local)* (cmd)* 'fim_procedimento' | 
                   'funcao' IDENT '(' (parametros)? ')' ':' tipo_estendido (declaracao_local)* (cmd)* 'fim_funcao'; 

parametro: 'var'? identificador (',' identificador)* ':' tipo_estendido; 

parametros: parametro (',' parametro)*; 

corpo: (declaracao_local)* (cmd)*; // declaração do comando

//tratamento de palavras chave
cmd: cmdLeia | cmdEscreva | cmdSe | cmdCaso | cmdPara | cmdEnquanto | cmdFaca | cmdAtribuicao | cmdChamada | cmdRetorne; // Comandos

cmdLeia: 'leia' '(' '^'? identificador (',' '^'? identificador)* ')'; // Comando de leitura

cmdEscreva: 'escreva' '(' expressao (',' expressao)* ')'; // Comando de escrita

cmdSe: 'se' expressao 'entao' (cmd)* ('senao' (cmd)*)? 'fim_se'; // Comando condicional

cmdCaso: 'caso' exp_aritmetica 'seja' selecao ('senao' (cmd)*)? 'fim_caso'; // Comando caso

cmdPara: 'para' IDENT '<-' exp_aritmetica 'ate' exp_aritmetica 'faca' (cmd)* 'fim_para'; // Comando para

cmdEnquanto: 'enquanto' expressao 'faca' (cmd)* 'fim_enquanto'; // Comando enquanto

cmdFaca: 'faca' (cmd)* 'ate' expressao; // Comando faça

cmdAtribuicao: '^'? identificador '<-' expressao; // Comando de atribuição

cmdChamada: IDENT '(' expressao (',' expressao)* ')'; // Comando de chamada de função/procedimento

cmdRetorne: 'retorne' expressao; // Comando de retorno

selecao: (item_selecao)*; 

item_selecao: constantes ':' (cmd)*; 

constantes: numero_intervalo (',' numero_intervalo)*; 

numero_intervalo: (op_neg)? NUM_INT ('..' (op_neg)? NUM_INT)?; 

op_neg: '-'; // Operador que torna o valor inverso


//tratamento de expresões relacionais como 3>5
exp_relacional: exp_aritmetica (op_relacional exp_aritmetica)?; // Expressão relacional

op_relacional: '=' | '>' |'<' | '<=' | '>=' | '<>'; 

//trata expressões aritimeticas em cascata
exp_aritmetica: termo (op1 termo)*; // responsavel por mais e menos

termo: fator (op2 fator)*; // responsavel por vezes e divisão

fator: parcela (op3 parcela)*; // responsavel por resot

//operações basicas
op1: '+' | '-'; 

op2: '*' | '/';

op3: '%'; 


//parte da expressão aritimetica, as do nivel mais basico, permitem inserir mais expressões
parcela: (op_neg)? parcela_unario | parcela_nao_unario; 

parcela_unario: '^'? identificador | IDENT '(' expressao (',' expressao)* ')' | NUM_INT | NUM_REAL | '(' expressao ')'; 

parcela_nao_unario: '&' identificador | CADEIA; 

//tratamento de expressões logicas,com as seguinte importancias não>e>ou em cascata
expressao: termo_logico (op_or termo_logico)*;//opção pra ou 

termo_logico: fator_logico (op_and fator_logico)*; //opção pra e

fator_logico: op_neg_logico? parcela_logica; //opção pra negar

parcela_logica:  exp_relacional | ('verdadeiro' | 'falso'); //é a relação entre dois ou mais 

op_and: 'e'; // Operador lógico AND

op_or: 'ou'; // Operador lógico OR

op_neg_logico: 'nao';// operado de contrario

fragment DIGITO: [0-9]; // Definição de um dígito

NUM_INT: DIGITO+; // Definição de números inteiros

NUM_REAL: DIGITO+ ('.' DIGITO+)?; // Definição de números reais

IDENT: ([a-zA-Z])([a-zA-Z]|DIGITO|'_')*; // variaveis

COMENTARIO: '{' ~('\n'|'\r'|'{'|'}')* '}' '\n'?'\r'? {skip();}; // Comentário

COMENTARIO_NAO_FECHADO: '{' ~('\n'|'\r'|'{'|'}')* '\n'? '\r'?; // Erro de comentário não fechado

CADEIA: '"' ( ESC_SEQ | ~('"'|'\\'|'\n'|'\r') )* '"'; // Cadeia de caracteres

CADEIA_LITERAL_NAO_FECHADA: '"' ( ESC_SEQ | ~('"'|'\\') )* '\n'? '\r'?; // Erro de cadeia de caracteres não fechada

ESC_SEQ: '\\\''; // Sequência de escape

WS: (' ' | '\n' | '\r' | '\t') {skip();}; // Espaço em branco

ERRO: ~('a'); // Erro
