document
.getElementById("formUsuario")
.addEventListener("submit", function(e){

    e.preventDefault();

    const campos = [
        "nome",
        "telefone",
        "setor",
        "login",
        "senha",
        "logradouro",
        "numero",
        "bairro",
        "cidade",
        "estado",
        "cep"
    ];

    for(let campo of campos){

        const valor =
        document.getElementById(campo).value.trim();

        if(valor === ""){
            alert("Preencha todos os campos.");
            document.getElementById(campo).focus();
            return;
        }
    }

    alert("Usuário cadastrado com sucesso!");

});

function limparCampos(){

    document
    .getElementById("formUsuario")
    .reset();
}


