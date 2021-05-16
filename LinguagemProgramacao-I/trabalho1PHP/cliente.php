<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="./css/forms.css">
    <link rel="stylesheet" href="./css/livros.css">


</head>

<body>

    <div>
        <div class="boxtitulo">
            <div class="titulo">Cadastre-se para comprar seus livros favoritos!</div>
            <div class='logo'>
                <img src='./img/book.png' width='70px'></img>
                <div class='nome'>
                    <p>BOOKS</p>
                    <p>GILMORE</p>
                </div>
            </div>
        </div>
        <div>
            <form action="home.php?n=4" method="post" class="forms">
                <div class="item-div">
                    <label for="nome"> Nome:</label> <input type="text" id="nome" name="nome" placeholder="nome" required />
                </div>
                <div class="item-div"> <label for="email"> E-mail:</label>
                    <input type="email" id="email" placeholder="email@email.com" name="email" required />
                </div>
                <div class="item-div"> <label for="senha"> Senha</label>
                    <input type="password" id="senha" placeholder="senha" name="senha" required />
                </div>
                <div class="item-div"> <label for="celular"> Celular:</label>
                    <input type="tel" id="celular" name="celular" placeholder="celular">
                </div>

                <div class="checkbox">
                    <span>Quais gêrenos você gosta de ler?</span>
                    <div>
                        <input type="checkbox" name="genero[0]" value="suspense"> Suspense
                    </div>
                    <div> <input type="checkbox" name="genero[1]" value="aventura"> Aventura
                    </div>
                    <div> <input type="checkbox" name="genero[2]" value="romance"> Romance
                    </div>
                    <div> <input type="checkbox" name="genero[3]" value="drama"> Drama
                    </div>
                    <div> <input type="checkbox" name="genero[4]" value="ficcao"> Ficção
                    </div>
                    <div> <input type="checkbox" name="genero[5]" value="terror"> Terror
                    </div>
                    <div> <input type="checkbox" name="genero[6]" value="biografia"> Biografia
                    </div>
                </div>
                <div class="checkbox"><label for="promo"> Deseja receber promoções por e-mail?</label>
                    <div>
                        <input type="radio" name="promo" value="sim">Sim
                        <input type="radio" name="promo" value="nao">Não
                    </div>
                </div>
                <button type="submit" name="Enviar" value="Enviar">Enviar</button>
            </form>
        </div>
</body>

</html>