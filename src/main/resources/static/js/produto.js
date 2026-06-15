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
                    "#tblProduto tbody tr"
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

function voltar(){
   
    window.location.href="/menu";
}

function novoProduto(){
   
    window.location.href="/cadastro_produto";
}

function prepararExclusao(botao) {

    const id = botao.dataset.id;
    const nome = botao.dataset.nome;

    document.getElementById("nomeProduto")
            .textContent = nome;

    document.getElementById("btnConfirmarExcluir")
            .href = "/produtos/excluir/" + id;
}

const modalExcluir = document.getElementById('modalExcluir');

modalExcluir.addEventListener('hidden.bs.modal', function () {

    document.querySelector('.btn-novo').focus();

});