document.addEventListener("DOMContentLoaded", () => {

    console.log("Tela de usuários carregada");

});

function editarUsuario(id){

    alert("Editar usuário: " + id);

}

function excluirUsuario(id){

    if(confirm("Deseja excluir este usuário?")){

        alert("Usuário excluído.");

    }

}


