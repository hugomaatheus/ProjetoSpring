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
					<li><a href="#Create">Tela Cliente</a></li>
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
										<input class="botao" type="button" onclick="window.open('../Tela-Pedidos-Cliente/Tela-Pedido-Cliente.html')" value="Pagina Pedido"></input>
									</td>
								</tr>
							</article>
							<article class="tabContainer" id="Editar">
								<tr>
									<td>
										<input class="botao" type="button" onclick="window.location.href='../Tela-Cadastro de Usuario/Cadastro.html'" value="Editar Usuario"></input>
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