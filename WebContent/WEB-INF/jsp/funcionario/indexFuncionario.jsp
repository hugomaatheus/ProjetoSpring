<html>
	<head>
		<title>titulo da pagina</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="style.css">
		<script type="text/javascript" src="../Plugin js/jquery-1.12.2.min.js"></script>
		<script type="text/javascript" src="../Plugin js/Projeto.js"></script>
	</head>
	<body>
		<form id="form">
			<header><!-- Cabeça da pagina -->
				<ul class="tabs">
					<li><a href="#Create">Tela Funcionario</a></li>
					<input id="btnSair" type="submit" value="Sair"/>
				</ul>
			</header>
			
			<section>
				<div class="tab_container">
					<article class= "cont_tab" id= "Create">
						<fieldset><legend>Menu</legend>
							<article class="tab_container" id="Pedidos">
								<tr>
									<td>
										<input class="botao" type="button" onclick="window.open('../Tela-Pedido-Funcionario/Tela-Pedido-Funcionario.html')" value="Pagina Pedido"></input>
									</td>
								</tr>
							</article>
							<article class="tabContainer" id="Reserva">
								<tr>
									<td>
										<input class="botao" type="button" onclick="window.open('../Tela-Reserva/Tela-Reserva.html')" value="Pagina Reserva"></input>
									</td>
								</tr>
							</article>
						</fieldset>
					</article>
				</div>		
			</section>
			<footer><!-- cabeçalho da pagina -->
				
			</footer>
		</form>
	</body>
</html>