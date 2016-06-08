<html>
	<head>
		<title>titulo da pagina</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="style.css">
		<script type="text/javascript" src="../Plugin js/jquery-1.12.2.min.js"></script>
		<script type="text/javascript" src="../Plugin js/Projeto.js"></script>
	</head>
	<body>
		<formid = "form">
			<header><!-- Cabeça da pagina -->
				<ul class="tabs">
				<li><a href="#Create">Editar Funcionario</a></li>
				<input id="btnSair" type="submit" value="Sair" />
				</ul>
			</header>
			
			<section>
				<form>
					<article class="cont_tab" id="Create">
						<fieldset><legend>Editar Funcionario</legend>
							<article class="tab_Cadastro" id="caixa_1">
								<tbody>
									<tr>
										<td align="right">
											<label id="labellogin"><em>Login:</em></label>
										</td>
										<td align="left">
											<input id="txtlogin" type="text" required=""></input>
										</td>
										<td align="right">
											<label id="labelsenha"><em>Senha:</em></label>
										</td>
										<td align="left">
											<input id="txtsenha" type="password" required="" />
										</td>
										<td align="right">
											<label id="labelNome"><em>Nome:</em></label>
										</td>
										<td align="left">
											<input id="txtNome" type="text" required="" />
										</td>
										<td align="right">
											<label id="labeltelefone"><em>Telefone:</em></label>
										</td>
										<td align="left">
											<input id="txttelefone" type="tel" required="required" maxlength="15" name="phone" pattern="\([0-9]{2}\) [0-9]{4,6}-[0-9]{3,4}$" title="Digite no seguinte formato (xx) xxxxx-xxxx" />
										<td>
									</tr>
								</tbody>
							</article>
							<article class="tab_Cadastro" id="caixa_2">
								<tbody>
									<tr>
										<td align="right">
											<label id="labelemail"><em>Emai:</em></label>
										</td>
										<td align="left">
											<input id="txtemail" type="email" required="required" class="input-text" name="email" pattern="[a-z0-9._%+-]+@[a-0-9.-]+\.[a-z]{2,4}$" />											
										</td>
										<td align="right">												
											<label id="labelcpf"><em>CPF:</em></label>
										</td>											
										<td align="left">
											<input id="txtcpf" Title="Digite no formato mmm.mmm.mmm-mm" type="text" required="" name="cpf" pattern="\d{3}\.\d{3}\.\d{3}-\d{2}$"/>
										</td>											
										<td align="right">
											<label id="labelcargo"><em>Cargo:</em></label>
										</td>											
										<td align="left">
											<input id="txtcargo" type="text" required="" />
										</td>											
										<td align="right">
											<label id="labelsalario"><em>Salario:</em></label>
										</td>											
										<td align="left">
											<input id="txtsalario" type="tel" required="required" maxlength="15" name="valor" pattern="([0-9]{1,3}\.)?[0-9]{1,3},[0-9]{2}$" title="Digite no seguinte formato min: x,xx  max: x.xxx,xx ou " />
										</td>
									</tr>
								</tbody>
							</article>
							<article id= caixa_salvar>
								<tr>
									<td align="right">
										<input id="btnsalvar" type="submit" value="Editar" />
									</td>
								</tr>
							</article>
						</fieldset>
					</article>
				</form>
			</section>
			
			<footer><!-- cabeçalho da pagina -->
				
			</footer>
		</form> 
	</body>
</html>