// Generated from compiladores\t4\Analisador.g4 by ANTLR 4.7.2
package compiladores.t4;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AnalisadorParser}.
 */
public interface AnalisadorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(AnalisadorParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(AnalisadorParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracoes(AnalisadorParser.DeclaracoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracoes(AnalisadorParser.DeclaracoesContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#decl_local_global}.
	 * @param ctx the parse tree
	 */
	void enterDecl_local_global(AnalisadorParser.Decl_local_globalContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#decl_local_global}.
	 * @param ctx the parse tree
	 */
	void exitDecl_local_global(AnalisadorParser.Decl_local_globalContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#declaracao_local}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao_local(AnalisadorParser.Declaracao_localContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#declaracao_local}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao_local(AnalisadorParser.Declaracao_localContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#declaracao_variavel}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao_variavel(AnalisadorParser.Declaracao_variavelContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#declaracao_variavel}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao_variavel(AnalisadorParser.Declaracao_variavelContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#declaracao_constante}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao_constante(AnalisadorParser.Declaracao_constanteContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#declaracao_constante}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao_constante(AnalisadorParser.Declaracao_constanteContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#declaracao_tipo}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao_tipo(AnalisadorParser.Declaracao_tipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#declaracao_tipo}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao_tipo(AnalisadorParser.Declaracao_tipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#variavel}.
	 * @param ctx the parse tree
	 */
	void enterVariavel(AnalisadorParser.VariavelContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#variavel}.
	 * @param ctx the parse tree
	 */
	void exitVariavel(AnalisadorParser.VariavelContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#identificador}.
	 * @param ctx the parse tree
	 */
	void enterIdentificador(AnalisadorParser.IdentificadorContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#identificador}.
	 * @param ctx the parse tree
	 */
	void exitIdentificador(AnalisadorParser.IdentificadorContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#dimensao}.
	 * @param ctx the parse tree
	 */
	void enterDimensao(AnalisadorParser.DimensaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#dimensao}.
	 * @param ctx the parse tree
	 */
	void exitDimensao(AnalisadorParser.DimensaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(AnalisadorParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(AnalisadorParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#tipo_basico}.
	 * @param ctx the parse tree
	 */
	void enterTipo_basico(AnalisadorParser.Tipo_basicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#tipo_basico}.
	 * @param ctx the parse tree
	 */
	void exitTipo_basico(AnalisadorParser.Tipo_basicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 */
	void enterTipo_basico_ident(AnalisadorParser.Tipo_basico_identContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 */
	void exitTipo_basico_ident(AnalisadorParser.Tipo_basico_identContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#tipo_estendido}.
	 * @param ctx the parse tree
	 */
	void enterTipo_estendido(AnalisadorParser.Tipo_estendidoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#tipo_estendido}.
	 * @param ctx the parse tree
	 */
	void exitTipo_estendido(AnalisadorParser.Tipo_estendidoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#valor_constante}.
	 * @param ctx the parse tree
	 */
	void enterValor_constante(AnalisadorParser.Valor_constanteContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#valor_constante}.
	 * @param ctx the parse tree
	 */
	void exitValor_constante(AnalisadorParser.Valor_constanteContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#registro}.
	 * @param ctx the parse tree
	 */
	void enterRegistro(AnalisadorParser.RegistroContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#registro}.
	 * @param ctx the parse tree
	 */
	void exitRegistro(AnalisadorParser.RegistroContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#declaracao_global}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao_global(AnalisadorParser.Declaracao_globalContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#declaracao_global}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao_global(AnalisadorParser.Declaracao_globalContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#parametro}.
	 * @param ctx the parse tree
	 */
	void enterParametro(AnalisadorParser.ParametroContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#parametro}.
	 * @param ctx the parse tree
	 */
	void exitParametro(AnalisadorParser.ParametroContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(AnalisadorParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(AnalisadorParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#corpo}.
	 * @param ctx the parse tree
	 */
	void enterCorpo(AnalisadorParser.CorpoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#corpo}.
	 * @param ctx the parse tree
	 */
	void exitCorpo(AnalisadorParser.CorpoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(AnalisadorParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(AnalisadorParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#cmdLeia}.
	 * @param ctx the parse tree
	 */
	void enterCmdLeia(AnalisadorParser.CmdLeiaContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#cmdLeia}.
	 * @param ctx the parse tree
	 */
	void exitCmdLeia(AnalisadorParser.CmdLeiaContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#cmdEscreva}.
	 * @param ctx the parse tree
	 */
	void enterCmdEscreva(AnalisadorParser.CmdEscrevaContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#cmdEscreva}.
	 * @param ctx the parse tree
	 */
	void exitCmdEscreva(AnalisadorParser.CmdEscrevaContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#cmdSe}.
	 * @param ctx the parse tree
	 */
	void enterCmdSe(AnalisadorParser.CmdSeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#cmdSe}.
	 * @param ctx the parse tree
	 */
	void exitCmdSe(AnalisadorParser.CmdSeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#cmdCaso}.
	 * @param ctx the parse tree
	 */
	void enterCmdCaso(AnalisadorParser.CmdCasoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#cmdCaso}.
	 * @param ctx the parse tree
	 */
	void exitCmdCaso(AnalisadorParser.CmdCasoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#cmdPara}.
	 * @param ctx the parse tree
	 */
	void enterCmdPara(AnalisadorParser.CmdParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#cmdPara}.
	 * @param ctx the parse tree
	 */
	void exitCmdPara(AnalisadorParser.CmdParaContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#cmdEnquanto}.
	 * @param ctx the parse tree
	 */
	void enterCmdEnquanto(AnalisadorParser.CmdEnquantoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#cmdEnquanto}.
	 * @param ctx the parse tree
	 */
	void exitCmdEnquanto(AnalisadorParser.CmdEnquantoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#cmdFaca}.
	 * @param ctx the parse tree
	 */
	void enterCmdFaca(AnalisadorParser.CmdFacaContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#cmdFaca}.
	 * @param ctx the parse tree
	 */
	void exitCmdFaca(AnalisadorParser.CmdFacaContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#cmdAtribuicao}.
	 * @param ctx the parse tree
	 */
	void enterCmdAtribuicao(AnalisadorParser.CmdAtribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#cmdAtribuicao}.
	 * @param ctx the parse tree
	 */
	void exitCmdAtribuicao(AnalisadorParser.CmdAtribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#cmdChamada}.
	 * @param ctx the parse tree
	 */
	void enterCmdChamada(AnalisadorParser.CmdChamadaContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#cmdChamada}.
	 * @param ctx the parse tree
	 */
	void exitCmdChamada(AnalisadorParser.CmdChamadaContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#cmdRetorne}.
	 * @param ctx the parse tree
	 */
	void enterCmdRetorne(AnalisadorParser.CmdRetorneContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#cmdRetorne}.
	 * @param ctx the parse tree
	 */
	void exitCmdRetorne(AnalisadorParser.CmdRetorneContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#selecao}.
	 * @param ctx the parse tree
	 */
	void enterSelecao(AnalisadorParser.SelecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#selecao}.
	 * @param ctx the parse tree
	 */
	void exitSelecao(AnalisadorParser.SelecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#item_selecao}.
	 * @param ctx the parse tree
	 */
	void enterItem_selecao(AnalisadorParser.Item_selecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#item_selecao}.
	 * @param ctx the parse tree
	 */
	void exitItem_selecao(AnalisadorParser.Item_selecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#constantes}.
	 * @param ctx the parse tree
	 */
	void enterConstantes(AnalisadorParser.ConstantesContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#constantes}.
	 * @param ctx the parse tree
	 */
	void exitConstantes(AnalisadorParser.ConstantesContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#numero_intervalo}.
	 * @param ctx the parse tree
	 */
	void enterNumero_intervalo(AnalisadorParser.Numero_intervaloContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#numero_intervalo}.
	 * @param ctx the parse tree
	 */
	void exitNumero_intervalo(AnalisadorParser.Numero_intervaloContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#op_neg}.
	 * @param ctx the parse tree
	 */
	void enterOp_neg(AnalisadorParser.Op_negContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#op_neg}.
	 * @param ctx the parse tree
	 */
	void exitOp_neg(AnalisadorParser.Op_negContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#exp_relacional}.
	 * @param ctx the parse tree
	 */
	void enterExp_relacional(AnalisadorParser.Exp_relacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#exp_relacional}.
	 * @param ctx the parse tree
	 */
	void exitExp_relacional(AnalisadorParser.Exp_relacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#op_relacional}.
	 * @param ctx the parse tree
	 */
	void enterOp_relacional(AnalisadorParser.Op_relacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#op_relacional}.
	 * @param ctx the parse tree
	 */
	void exitOp_relacional(AnalisadorParser.Op_relacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 */
	void enterExp_aritmetica(AnalisadorParser.Exp_aritmeticaContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 */
	void exitExp_aritmetica(AnalisadorParser.Exp_aritmeticaContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(AnalisadorParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(AnalisadorParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(AnalisadorParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(AnalisadorParser.FatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#op1}.
	 * @param ctx the parse tree
	 */
	void enterOp1(AnalisadorParser.Op1Context ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#op1}.
	 * @param ctx the parse tree
	 */
	void exitOp1(AnalisadorParser.Op1Context ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#op2}.
	 * @param ctx the parse tree
	 */
	void enterOp2(AnalisadorParser.Op2Context ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#op2}.
	 * @param ctx the parse tree
	 */
	void exitOp2(AnalisadorParser.Op2Context ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#op3}.
	 * @param ctx the parse tree
	 */
	void enterOp3(AnalisadorParser.Op3Context ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#op3}.
	 * @param ctx the parse tree
	 */
	void exitOp3(AnalisadorParser.Op3Context ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#parcela}.
	 * @param ctx the parse tree
	 */
	void enterParcela(AnalisadorParser.ParcelaContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#parcela}.
	 * @param ctx the parse tree
	 */
	void exitParcela(AnalisadorParser.ParcelaContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#parcela_unario}.
	 * @param ctx the parse tree
	 */
	void enterParcela_unario(AnalisadorParser.Parcela_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#parcela_unario}.
	 * @param ctx the parse tree
	 */
	void exitParcela_unario(AnalisadorParser.Parcela_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 */
	void enterParcela_nao_unario(AnalisadorParser.Parcela_nao_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 */
	void exitParcela_nao_unario(AnalisadorParser.Parcela_nao_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterExpressao(AnalisadorParser.ExpressaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitExpressao(AnalisadorParser.ExpressaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#termo_logico}.
	 * @param ctx the parse tree
	 */
	void enterTermo_logico(AnalisadorParser.Termo_logicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#termo_logico}.
	 * @param ctx the parse tree
	 */
	void exitTermo_logico(AnalisadorParser.Termo_logicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#fator_logico}.
	 * @param ctx the parse tree
	 */
	void enterFator_logico(AnalisadorParser.Fator_logicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#fator_logico}.
	 * @param ctx the parse tree
	 */
	void exitFator_logico(AnalisadorParser.Fator_logicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#parcela_logica}.
	 * @param ctx the parse tree
	 */
	void enterParcela_logica(AnalisadorParser.Parcela_logicaContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#parcela_logica}.
	 * @param ctx the parse tree
	 */
	void exitParcela_logica(AnalisadorParser.Parcela_logicaContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#op_and}.
	 * @param ctx the parse tree
	 */
	void enterOp_and(AnalisadorParser.Op_andContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#op_and}.
	 * @param ctx the parse tree
	 */
	void exitOp_and(AnalisadorParser.Op_andContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#op_or}.
	 * @param ctx the parse tree
	 */
	void enterOp_or(AnalisadorParser.Op_orContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#op_or}.
	 * @param ctx the parse tree
	 */
	void exitOp_or(AnalisadorParser.Op_orContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorParser#op_neg_logico}.
	 * @param ctx the parse tree
	 */
	void enterOp_neg_logico(AnalisadorParser.Op_neg_logicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorParser#op_neg_logico}.
	 * @param ctx the parse tree
	 */
	void exitOp_neg_logico(AnalisadorParser.Op_neg_logicoContext ctx);
}