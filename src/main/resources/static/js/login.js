document
        .addEventListener("DOMContentLoaded", () => {
    const campoPesquisa = document.getElementById("login");

    if (campoPesquisa) {
        campoPesquisa.focus();
    }
});

document
.getElementById("formLogin")
.addEventListener("submit", async function(e){

    e.preventDefault();

    const login =
        document.getElementById("login").value.trim();

    const senha =
        document.getElementById("senha").value.trim();

    if (!login || !senha) {

        mostrarToast("Informe login e senha");
        return;
    }

    const response = await fetch("/login", {

        method: "POST",

        headers: {
            "Content-Type":
                "application/x-www-form-urlencoded"
        },

        body:
            `login=${encodeURIComponent(login)}&senha=${encodeURIComponent(senha)}`
    });

    const autenticado =
        await response.json();

    if (autenticado) {

        window.location.href = "/menu";

    } else {

        mostrarToast("Login ou senha inválidos");
    }
});