<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="Cache-Control" content="no-store" />
    <link rel="stylesheet" href="./css/menu.css">
    <link rel="stylesheet" href="./css/boasvindas.css">
    <link rel="stylesheet" href="./css/livros.css">


</head>

<body>
    <header>
        <nav id="menu">
            <ul>
                <li><a href="home.php"> Home</a></li>
                <li><a href="home.php?n=1"> Vendedor</a></li>
                <li><a href="home.php?n=2"> Cliente</a></li>
                <li><a href="home.php?n=3"> Livro</a></li>

            </ul>
        </nav>
    </header>

    <div>
        <?php

        $x = isset($_GET['n']) ? $_GET['n'] : null;

        switch ($x) {
            case 1:
                include("vendedor.php");
                break;
            case 2:
                include("cliente.php");
                break;
            case 3:
                include("livro.php");
                break;
            case 4:
                include("boasvindas.php");
                break;
            case 5:
                include("vendedor.php");
                break;
        }
        if ($x == null) {

            echo "     
            <div class='boxfrase'>
                <h2 class='frase'>
                ''Eu vivo em dois mundos, um deles é o mundo dos livros. -Rory Gilmore''
                </h2> 
            </div>
            <div class='boxcard'>
                <span class='descricao'>
                    <img src='./img/coupon.png' height='100px'></img>
                    <p> Cadastre sua empresa e anuncie seus livros!</p>
                    <a href='home.php?n=1' ><button class='botao' type=button>Vamos ></button></a>
                </span>
                <span class='descricao'>
                    <img src='./img/rating.png' height='100px'></img>
                    <p>Cadastre-se para comprar seus livros favoritos!</p>
                    <a href='home.php?n=2' ><button class='botao' type=button>Vamos ></button></a>  
                </span>
                <span class='descricao'>  
                    <img src='./img/busca.png' height='100px'></img>
                    <p>Solicite livros ainda não disponíveis no site!</p> 
                    <a href='home.php?n=3' ><button class='botao' type=button>Vamos ></button></a>
                </span>  
            </div>
        ";
            echo "
        <div class='listalivros'>
            <img src='./img/left-arrow.png' height='50px'></img>
            <img src='./img/carrie.jpg' width='150px' height='200px'></img>
            <img src='./img/2 (2).jpg' width='150px' height='200px'></img>
            <img src='./img/1 (2).jpg' width='150px' height='200px'></img>
            <img src='./img/anna.jpg' width='150px' height='200px'></img>
            <img src='./img/angela.jpg' width='150px' height='200px'></img>
            <img src='./img/festa.jpg' width='150px' height='200px'></img>
            <img src='./img/orgulho.jpg' width='150px' height='200px'></img>
            <img src='./img/next.png'  height='50px'></img>
        </div>
        ";
        }
        ?>
    </div>
</body>

</html>