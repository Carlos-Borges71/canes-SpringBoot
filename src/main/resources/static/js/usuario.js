document
        .addEventListener("DOMContentLoaded", () => {
            const campoPesquisa = document.getElementById("txtPesquisa");

            if (campoPesquisa) {
                campoPesquisa.focus();
            }
        });

const pesquisa = document
        .getElementById("txtPesquisa");

pesquisa.addEventListener("keyup", () => {

    let filtro =
            pesquisa.value.toLowerCase();

    let linhas =
            document.querySelectorAll(
                    "#tblUsuarios tbody tr"
                    );

    linhas.forEach(linha => {

        let textoLinha =
                linha.textContent.toLowerCase();

        linha.style.display =
                textoLinha.includes(filtro)
                ? ""
                : "none";

    });

});

function voltar() {
    window.location.href = "/menu";
}



function novoUsuario() {
    window.location.href = "/cadastro_usuario";
}

function prepararExclusao(botao) {

    const id = botao.dataset.id;
    const nome = botao.dataset.nome;

    document.getElementById("nomeUsuario")
            .textContent = nome;

    document.getElementById("btnConfirmarExcluir")
            .href = "/usuarios/excluir/" + id;
}

const modalExcluir = document.getElementById('modalExcluir');

modalExcluir.addEventListener('hidden.bs.modal', function () {

    document.querySelector('.btn-novo').focus();

});