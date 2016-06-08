<html>
	<head>
		<title>Lista Funcionarios</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="style.css">
	</head>
	<body>
			<header>
			<c:url var="urlNewF"  value="/funcionario/novoFuncionario"/>
			<input id="novo" type="button" onclick="location.href='${urlNewF}'"; value="Cadatrar Funcionario" />
				<c:url var="urlOut" value="/logout/"/> 				
						<input id="btnSair" class="botao" type="button" onclick="window.location.href='${urlOut}'" value="Sair"/>
			</header>
			
				<article class="tab_container" id="pesquisa">
					<tr> 
						<td>
							<label for="txtNome"><em>Nome:</em></label>
						</td>
						<td align="left">
							<input id="filtro" type="text" autofocus="" required="" />
						</td>
						<td align="left">
							<input id="btnPesquisar" type="submit" value="Pesquisar" />
						</td>
					</tr>
				</article>
				<article class="tabContainer" id="lista">
					<table>
						<thead>
							<tr>
								<th class="tabela-coluna"><span>Nome</span></th>
								<th class="tabela-coluna"><span>CPF</span></th>
								<th class="tabela-coluna"><span>Cargo</span></th>
								<th class="tabela-coluna"><span>Salario</span></th>
								<th class="tabela-coluna"><span>Acoes</span></th>
							</tr>
						</thead>
					</table>
				<article class="scrollContainer">
					<table>
						<tr>
							<td class="tabela-coluna"><span>funcionario.nome</span></td>
							<td class="tabela-coluna"><span>funcionario.cpf</span></td>
							<td class="tabela-coluna"><span>funcionario.cargo</span></td>
							<a href="">[inativar]</a>					
							<td class="tabela-coluna">
								<span>
									<a href="Comando para excluir"> [excluir]</a>
									<a href="Comando para inativar">[Inativar]</a>
								</span>
							</td>
						</tr>
					</table>
				</article>
				</article>
			
			<footer><!-- cabeçalho da pagina -->
				
			</footer>
		</form> 
	</body>
</html>