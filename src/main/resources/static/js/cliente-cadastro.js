document
.getElementById("formCliente")
.addEventListener("submit", function(event){

    event.preventDefault();

    let nome =
        document.getElementById("nome").value;

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

    if(nome.trim() === ""){

        alert("Informe o nome");

        return;
    }

    if(telefone.trim() === ""){

        alert("Informe o telefone");

        return;
    }

    if(logradouro.trim() === ""){

        alert("Informe o logradouro");

        return;
    }

    if(numero.trim() === ""){

        alert("Informe o número");

        return;
    }

    if(bairro.trim() === ""){

        alert("Informe o bairro");

        return;
    }

    if(cidade.trim() === ""){

        alert("Informe a cidade");

        return;
    }

    if(estado.trim() === ""){

        alert("Informe o estado");

        return;
    }

    if(cep.trim() === ""){

        alert("Informe o CEP");

        return;
    }

    alert("Cliente cadastrado com sucesso!");

    window.location.href="/clientes";
});

function voltar(){
    window.location.href="/clientes";
}

