function mostrarToast(mensagem) {

    document.getElementById("toastTexto").textContent =
        mensagem;

    const toast =
        new bootstrap.Toast(
            document.getElementById("toastMensagem")
        );

    toast.show();
}


