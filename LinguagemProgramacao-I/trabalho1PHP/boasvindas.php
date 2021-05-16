<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="./css/forms.css">
    <link rel="stylesheet" href="./css/livros.css">
    <link rel="stylesheet" href="./css/boasvindas.css">



</head>

<body>
    <?php

    if (isset($_POST['Enviar'])) {
        $nome = $_POST['nome'];
        $email = $_POST['email'];
        $celular = $_POST['celular'];
        $senha = $_POST['senha'];
        $primeiroNome = strstr($nome, ' ', true);
        echo "
        <div class='container'> 
            <h5 class='boasvindas'> Bem-vindo(a) $primeiroNome !<h5>
        <div class='logo'>
            <img src='./img/book.png' width='70px'></img>
            <div class='nome'>
                <p>BOOKS</p>
                <p>GILMORE</p> 
            </div>
        </div>
        </div>";

        function formataTelefone($numero)
        {

            $novo = substr_replace($numero, '(', 0, 0);
            $novo = substr_replace($novo, '9', 3, 0);
            $novo = substr_replace($novo, ') ', 3, 0);
            return $novo;
        };
        $numeroformatado = formataTelefone($celular);

        echo "<div class='box'>
        <div>
            <p class='item-perfil'>
            Nome: $nome
            </p>
            <p class='item-perfil'>
            E-mail: $email
            </p>            
            <p class='item-perfil'>
            Celular: $numeroformatado
            </p>
            </div>
            
            ";
        $promo = isset($_POST['promo']) ? $_POST['promo'] : null;
        if ($promo != null && $promo == 'sim') {
            echo "<p class='item-perfil'>Você receberá nossas promoções por e-mail! </p>";
        }

        $genero = isset($_POST['genero']) ? $_POST['genero'] : null;
        if ($genero != null) {
            echo "<p class='item-perfil'>Gêneros favoritos:</p>";

            foreach ($genero as $key => $value) {
                if ($value === 'ficcao') {
                    "|| ficção  ";
                } else {

                    echo "|| $value  ";
                }
            }
        }
        echo "</div>\n";
    }
    echo "<div class='listalivros'>";
    if (in_array('terror', $genero)) {
        echo "<img src='./img/carrie.jpg' width='150px' height='200px'></img>";
    }
    if (in_array('aventura', $genero)) {
        echo "<img src='./img/2 (2).jpg' width='150px' height='200px'></img>";
    }
    if (in_array('ficcao', $genero)) {
        echo "<img src='./img/1 (2).jpg' width='150px' height='200px'></img>";
    }
    if (in_array('romance', $genero)) {
        echo "<img src='./img/anna.jpg' width='150px' height='200px'></img>";
    }
    if (in_array('biografia', $genero)) {
        echo "<img src='./img/angela.jpg' width='150px' height='200px'></img>";
    }
    if (in_array('suspense', $genero)) {
        echo "<img src='./img/festa.jpg' width='150px' height='200px'></img>";
    }
    if (in_array('drama', $genero)) {
        echo "<img src='./img/orgulho.jpg' width='150px' height='200px'></img>";
    }
    echo "    </div>";
    ?>
</body>

</html>