<!DOCTYPE html>
<html>
<head>
	<title>Vn vo dich</title>
	<link rel="stylesheet" type="text/css" href="styleHappyGame.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
	<div class="container" onclick="expand()">
		<div class="toggle" id="toggle">
			<i class="material-icons" id="add">
				star
			</i>
		</div>
	</div>
	<div class="menu" id="menu" id="menu">
		<div class="item">
			<a href="#">
				<i class="material-icons">home</i>
			</a>
		</div>
		<div class="item">
                    <!--Register (click vao thi sang trang Register.jsp)-->
			<a href="register">
				<i class="material-icons">add_circle_outline</i>
			</a>
		</div>
		<div class="item">
			<a href="#">
				<i class="material-icons">contact_support</i>
			</a>
		</div>
		<div class="item">
                    <!--Game(Click vao thi sang trang Main.jsp neu da Login)-->
			<a href="#">
				<i class="material-icons">videogame_asset</i>
			</a>
		</div>
		<div class="item">
			<a href="#">
				<i class="material-icons">credit_card</i>
			</a>
		</div>
		<div class="item">
                    <!--Login(Click vao thi sang trang Login.jsp)-->
			<a href="#">
				<i class="material-icons">account_box</i>
			</a>
		</div>
	</div>
	<script type="text/javascript">
		var j = 0;
		var i = document.getElementById("menu").childNodes;
		function expand() {
			if(j==0) {
				document.getElementById("add").style.transform = 'rotate(360deg)';
				document.getElementById("menu").style.transform='scale(1)';
				i[1].style.transform='translateY(-160px)';
				i[3].style.transform='translate(140px,-80px)';
				i[5].style.transform='translate(140px,80px)';
				i[7].style.transform='translateY(160px)';
				i[9].style.transform='translate(-140px,80px)';
				i[11].style.transform='translate(-140px,-80px)';
				j=1;
			}else {
				document.getElementById("add").style.transform = 'rotate(0deg)';
				document.getElementById("menu").style.transform='scale(0.9)';
				i[1].style.transform='translateY(0)';
				i[3].style.transform='translate(0)';
				i[5].style.transform='translate(0)';
				i[7].style.transform='translateY(0)';
				i[9].style.transform='translate(0)';
				i[11].style.transform='translate(0)';
				j=0;
			}
		}
	</script>
</body>
</html>