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

            let login =
                    document.getElementById("login").value;

            let senha =
                    document.getElementById("senha").value;

            let setor =
                    document.getElementById("setor").value;

            let telefone =
                    document.getElementById("telefone").value;

            let logradouro =
                    document.getElementById("logradouro").value;

            let numero =
                    document.getElementById("numero").value;

            let bairro =
                    document.getElementById("bairro").value;

            let cidade =
                    document.getElementById("cidade").value;

            let estado =
                    document.getElementById("estado").value;

            let cep =
                    document.getElementById("cep").value;

            if (nome.trim() === "") {

                mostrarToast("Informe o nome");

                event.preventDefault();
                return;

            }

            if (setor.trim() === "") {

                mostrarToast("Informe o setor");

                event.preventDefault();
                
                return;

            }

            if (login.trim() === "") {

                mostrarToast("Informe o login");

                event.preventDefault();
                return;

            }

            if (senha.trim() === "") {

                mostrarToast("Informe o senha");

                event.preventDefault();
                return;

            }

            if (telefone.trim() === "") {

                mostrarToast("Informe o telefone");
                event.preventDefault();

                return;

            }

            if (logradouro.trim() === "") {

                mostrarToast("Informe o logradouro");
                event.preventDefault();

                return;

            }

            if (numero.trim() === "") {

                mostrarToast("Informe o número");
                event.preventDefault();
                return;

            }

            if (bairro.trim() === "") {

                mostrarToast("Informe o bairro");
                event.preventDefault();
                return;

            }

            if (cidade.trim() === "") {

                mostrarToast("Informe a cidade");
                event.preventDefault();
                return;

            }

            if (estado.trim() === "") {

                mostrarToast("Informe o estado");
                event.preventDefault();
                return;

            }

            if (cep.trim() === "") {

                mostrarToast("Informe o CEP");
                event.preventDefault();
                return;

            }


        });

function voltar() {

    window.location.href = "/usuarios";
}


