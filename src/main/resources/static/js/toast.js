function mostrarToast(mensagem) {

    const toastTexto =
        document.getElementById("toastTexto");

    const toastMensagem =
        document.getElementById("toastMensagem");

    if (!toastTexto || !toastMensagem) {
        console.error("Toast não encontrado no HTML.");
        return;
    }

    toastTexto.textContent = mensagem;

    const toast =
        new bootstrap.Toast(toastMensagem);

    toast.show();
}

