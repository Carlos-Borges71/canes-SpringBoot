document
        .addEventListener("DOMContentLoaded", () => {
            const campoNome = document.getElementById("nome");

            if (campoNome) {
                campoNome.focus();
            }
        });
        

document
        .querySelector("form")
        .addEventListener("submit", function (event) {

          
            let nome =
                    document.getElementById("nome").value;

            let codigo =
                    document.getElementById("codigo").value;

            let estoque =
                    document.getElementById("estoque").value;

            let valor =
                    document.getElementById("valor").value;

            if (nome.trim() === "") {

                mostrarToast("Informe o produto");
                event.preventDefault();
                return;
            }

            if (codigo.trim() === "") {

                mostrarToast("Informe o código");
                event.preventDefault();
                return;
            }

            if (estoque.trim() === "") {

                mostrarToast("Informe a quantidade");
                event.preventDefault();
                return;
            }

            if (valor.trim() === "") {

                mostrarToast("Informe o valor");
                event.preventDefault();
                return;
            }

            mostrarToast("Produto cadastrado com sucesso!");

            
        });

function voltar() {
    window.location.href = "/produtos";
}

