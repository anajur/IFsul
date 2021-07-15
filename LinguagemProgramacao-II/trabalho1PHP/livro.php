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
        <div class="titulo">Procurou algum livro e não encontrou?</div>
        <div class="subtitulo">Conta pra gente, vamos em busca! &#128525;</div>

    </div>

    <div>
        <form action="home.php?n=3" method="post" class="forms">
            <div class="item-div">
                <label for="titulo"> Título:</label> <input type="text" id="titulo" name="titulo" placeholder="título" required />
            </div>
            <div class="item-div"> <label for="autor"> Autor</label>
                <input type="text" id="autor" placeholder="autor" name="autor" required />
            </div>
            <div class="checkbox">
                <span>Gênero do livro:</span>
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
                <div> <input type="checkbox" name="genero[6]" value="autoajuda"> Autoajuda
                </div>
                <div> <input type="checkbox" name="genero[7]" value="outro"> Outro
                </div>
            </div>
            <button type="submit" name="Enviar" value="Enviar">Enviar</button>

        </form>
    </div>
    <?php if (isset($_POST['Enviar'])) {
        $titulo = $_POST['titulo'];
        $autor = $_POST['autor'];
        $genero = isset($_POST['genero']) ? $_POST['genero'] : null;
        echo
        "<div class='boxlivro'>
            <p class='item-perfil'>Livro: $titulo</p>
            <p class='item-perfil'>Autor: $autor</p>";
        if ($genero != null) {
            foreach ($genero as $key => $value) {
                echo "|| $value || ";
            }
        }
        echo "<p>Sua solicitação foi cadastrada!</p></div>";
    }
    ?>
</body>

</html>