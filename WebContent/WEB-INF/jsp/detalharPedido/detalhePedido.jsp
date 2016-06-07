<html>
	<head>
		<title>Detalhe Pedido</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="../../estilos/estiloDetalhar.css">
	</head>
	<body>
		<form id="form">
			<header>
					<a href="#Sair">Sair</a>
			</header>
			
			<fieldset id="criar"><legend>Detalhe Pedidos</legend>
				<article id="pesquisa">
					<tr> 
						<td align="right">
							<label id="labelnumero"><em>Numero:${itemPedido.pedido.id}</em></label>
						</td>
						<td align="right">
							<label id="labelstatus"><em>Status:${itemPedido.pedido.status}</em></label>
						</td>
						<td align="right">
							<label id="labelqtd"><em>Quantidade:${itemPedido.quantidade}</em></label>
						</td>
						<td align="right">
							<label id="labeltroco"><em>Troco para:</em></label>
						</td>
					</tr>			
				</article>

				<article class="tabContainer" id="lista">
					<table>
						<thead>
							<tr>
								<th class="tabela-coluna"><span>Codigo</span></th>
								<th class="tabela-coluna"><span>Descricao</span></th>
								<th class="tabela-coluna"><span>Quantidade</span></th>
								<th class="tabela-coluna"><span>Total(R$)</span></th>
							</tr>
						</thead>
					</table>
				<article class="scrollContainer">
					<table>
					<c:forEach var="itemPedido" items="${itemPedidos}" >
						<tr>
							<td class="tabela-coluna"><span>${itemPedido.pedido.id}</span></td>
							<td class="tabela-coluna"><span>${itemPedido.cardapio.nome}</span></td>
							<td class="tabela-coluna"><span>${itemPedido.quantidade}</span></td>
							<td class="tabela-coluna"><span>${itemPedido.cardapio.preco}</span></td>
						</tr>
					</c:forEach>
					</table>
				</article>
				</article>
				<article>
					<td align="right">
						<input id="btnAtender" class="btn" type="button" value="Atender" />
					</td>
					<td align="right">
						<input id="btnCancelar" class="btn" type="button" value="Cancelar" />
					</td>
					<td align="right">
						<input id="btnVoltar" class="btn" type="button" onclick="javascript:history.back(); self.location.reload();" value="Voltar" />
					</td>
				</article>
			</fieldset>

			<footer><!-- cabeçalho da pagina -->
				
			</footer>
		</form>
	</body>
</html>