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
                    "#tblClientes tbody tr"
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

function novoCliente() {
    window.location.href = "/cadastro_cliente";
}

function prepararExclusao(botao) {

    const id = botao.dataset.id;
    const nome = botao.dataset.nome;

    document.getElementById("nomeCliente")
            .textContent = nome;

    document.getElementById("btnConfirmarExcluir")
            .href = "/clientes/excluir/" + id;
}

const modalExcluir = document.getElementById('modalExcluir');

modalExcluir.addEventListener('hidden.bs.modal', function () {

    document.querySelector('.btn-novo').focus();

});

