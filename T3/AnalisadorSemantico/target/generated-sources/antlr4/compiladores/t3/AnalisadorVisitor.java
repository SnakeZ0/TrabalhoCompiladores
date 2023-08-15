// Generated from compiladores\t3\Analisador.g4 by ANTLR 4.7.2
package compiladores.t3;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AnalisadorParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AnalisadorVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(AnalisadorParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#declaracoes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracoes(AnalisadorParser.DeclaracoesContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#decl_local_global}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl_local_global(AnalisadorParser.Decl_local_globalContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#declaracao_local}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao_local(AnalisadorParser.Declaracao_localContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#declaracao_variavel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao_variavel(AnalisadorParser.Declaracao_variavelContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#declaracao_constante}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao_constante(AnalisadorParser.Declaracao_constanteContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#declaracao_tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao_tipo(AnalisadorParser.Declaracao_tipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#variavel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariavel(AnalisadorParser.VariavelContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#identificador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentificador(AnalisadorParser.IdentificadorContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#dimensao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimensao(AnalisadorParser.DimensaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(AnalisadorParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#tipo_basico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_basico(AnalisadorParser.Tipo_basicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_basico_ident(AnalisadorParser.Tipo_basico_identContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#tipo_estendido}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_estendido(AnalisadorParser.Tipo_estendidoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#valor_constante}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValor_constante(AnalisadorParser.Valor_constanteContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#registro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegistro(AnalisadorParser.RegistroContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#declaracao_global}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao_global(AnalisadorParser.Declaracao_globalContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#parametro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametro(AnalisadorParser.ParametroContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#parametros}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametros(AnalisadorParser.ParametrosContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#corpo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCorpo(AnalisadorParser.CorpoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmd(AnalisadorParser.CmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#cmdLeia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdLeia(AnalisadorParser.CmdLeiaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#cmdEscreva}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdEscreva(AnalisadorParser.CmdEscrevaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#cmdSe}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdSe(AnalisadorParser.CmdSeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#cmdCaso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdCaso(AnalisadorParser.CmdCasoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#cmdPara}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdPara(AnalisadorParser.CmdParaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#cmdEnquanto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdEnquanto(AnalisadorParser.CmdEnquantoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#cmdFaca}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdFaca(AnalisadorParser.CmdFacaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#cmdAtribuicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdAtribuicao(AnalisadorParser.CmdAtribuicaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#cmdChamada}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdChamada(AnalisadorParser.CmdChamadaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#cmdRetorne}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdRetorne(AnalisadorParser.CmdRetorneContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#selecao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelecao(AnalisadorParser.SelecaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#item_selecao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem_selecao(AnalisadorParser.Item_selecaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#constantes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantes(AnalisadorParser.ConstantesContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#numero_intervalo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumero_intervalo(AnalisadorParser.Numero_intervaloContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#op_neg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_neg(AnalisadorParser.Op_negContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#exp_relacional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_relacional(AnalisadorParser.Exp_relacionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#op_relacional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_relacional(AnalisadorParser.Op_relacionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_aritmetica(AnalisadorParser.Exp_aritmeticaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#termo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermo(AnalisadorParser.TermoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#fator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFator(AnalisadorParser.FatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#op1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp1(AnalisadorParser.Op1Context ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#op2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp2(AnalisadorParser.Op2Context ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#op3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp3(AnalisadorParser.Op3Context ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#parcela}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela(AnalisadorParser.ParcelaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#parcela_unario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela_unario(AnalisadorParser.Parcela_unarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela_nao_unario(AnalisadorParser.Parcela_nao_unarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressao(AnalisadorParser.ExpressaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#termo_logico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermo_logico(AnalisadorParser.Termo_logicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#fator_logico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFator_logico(AnalisadorParser.Fator_logicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#parcela_logica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela_logica(AnalisadorParser.Parcela_logicaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#op_and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_and(AnalisadorParser.Op_andContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#op_or}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_or(AnalisadorParser.Op_orContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorParser#op_neg_logico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_neg_logico(AnalisadorParser.Op_neg_logicoContext ctx);
}