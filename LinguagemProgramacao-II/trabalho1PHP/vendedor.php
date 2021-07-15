<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="Cache-Control" content="no-store" />
    <link rel="stylesheet" href="./css/forms.css">
    <link rel="stylesheet" href="./css/livros.css">
</head>

<body>
    <div class="boxtitulo">
        <div class="titulo">Cadastre-se para vender seus livros!</div>
        <div class='logo'>
            <img src='./img/book.png' width='70px'></img>
            <div class='nome'>
                <p>BOOKS</p>
                <p>GILMORE</p>
            </div>
        </div>
    </div>
    <div>
        <form action="home.php?n=5" method="post" class="forms">
            <div class="item-div">
                <label for="nome"> Nome:</label> <input type="text" id="nome" name="nome" placeholder="nome" required />
            </div>
            <div class="item-div"> <label for="email"> E-mail:</label>
                <input type="email" id="email" placeholder="email@email.com" name="email" required />
            </div>
            <div class="item-div"> <label for="cnpj"> CNPJ</label>
                <input type="cnpj" id="cnpj" placeholder="cnpj" name="cnpj" required />
            </div>
            <div class="item-div"> <label for="senha"> Senha</label>
                <input type="password" id="senha" placeholder="senha" name="senha" required />
            </div>
            <button type="submit" name="Enviar" value="Enviar">Enviar</button>

        </form>
    </div>
    <?php
    if (isset($_POST['Enviar'])) {
        $nome = $_POST['nome'];
        $email = $_POST['email'];
        $cnpj = $_POST['cnpj'];
        $senha = $_POST['senha'];
        echo
        "<div class='boxlivro'>
            <p class='item-perfil'>  Cadastro concluído! Bem-vindo(a) a Books Gilmore!</p>
            <p class='item-perfil'>Nome: $nome</p>
            <p class='item-perfil'>E-mail: $email</p>            
            <p class='item-perfil'>CNPJ: $cnpj</p>  
        </div";
    }
    ?>
</body>

</html>