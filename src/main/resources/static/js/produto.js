document.addEventListener("DOMContentLoaded", () => {

    console.log("Tela Produtos carregada");

});

function excluirProduto(id){

    if(confirm("Deseja excluir o produto?")){

        alert("Produto " + id + " excluído");
    }

}

function editarProduto(id){

    alert("Editar produto " + id);

}


