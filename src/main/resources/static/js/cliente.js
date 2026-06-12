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

