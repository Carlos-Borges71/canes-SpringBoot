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

        let nome =
        linha.cells[1]
        .textContent
        .toLowerCase();

        linha.style.display =
        nome.includes(filtro)
        ? ""
        : "none";
    });

});


