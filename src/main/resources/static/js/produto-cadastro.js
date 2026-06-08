document
.getElementById("formProduto")
.addEventListener("submit", function(event){

    event.preventDefault();

    let produto =
        document.getElementById("produto").value;

    let codigo =
        document.getElementById("codigo").value;

    let quantidade =
        document.getElementById("quantidade").value;

    let valor =
        document.getElementById("valor").value;

    if(produto.trim() === ""){

        alert("Informe o produto");
        return;
    }

    if(codigo.trim() === ""){

        alert("Informe o código");
        return;
    }

    if(quantidade.trim() === ""){

        alert("Informe a quantidade");
        return;
    }

    if(valor.trim() === ""){

        alert("Informe o valor");
        return;
    }

    alert("Produto cadastrado com sucesso!");

});

