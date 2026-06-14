// ========================
// NOME
// ========================

function formatarLowerCase(campo) {

    let valor = campo.value.toLowerCase();

    valor = valor.replace(/\b\w/g, letra =>
        letra.toUpperCase()
    );

    campo.value = valor;
}

function apenasLetras(campo) {

    campo.value = campo.value.replace(
        /[^a-zA-ZÀ-ÿ\s]/g,
        ""
    );
}

// ========================
// TELEFONE
// ========================

function mascararTelefone(campo) {

    let valor = campo.value.replace(/\D/g, "");

    if (valor.length > 11) {
        valor = valor.substring(0, 11);
    }

    if (valor.length > 6) {

        valor = valor.replace(
            /^(\d{2})(\d{5})(\d{0,4}).*/,
            "($1) $2-$3"
        );

    } else if (valor.length > 2) {

        valor = valor.replace(
            /^(\d{2})(\d+)/,
            "($1) $2"
        );
    }

    campo.value = valor;
}

// ========================
// CEP
// ========================

function mascararCep(campo) {

    let valor = campo.value.replace(/\D/g, "");

    valor = valor.replace(
        /^(\d{5})(\d)/,
        "$1-$2"
    );

    campo.value = valor;
}

// ========================
// CPF
// ========================

function mascararCpf(campo) {

    let valor = campo.value.replace(/\D/g, "");

    valor = valor.replace(
        /(\d{3})(\d)/,
        "$1.$2"
    );

    valor = valor.replace(
        /(\d{3})(\d)/,
        "$1.$2"
    );

    valor = valor.replace(
        /(\d{3})(\d{1,2})$/,
        "$1-$2"
    );

    campo.value = valor;
}

// ========================
// APENAS NÚMEROS
// ========================

function apenasNumeros(campo) {

    campo.value = campo.value.replace(
        /\D/g,
        ""
    );
}

// ========================
// MOEDA (R$)
// ========================

function mascararMoeda(campo) {

    let valor = campo.value.replace(/\D/g, "");

    valor = (valor / 100).toFixed(2);

    valor = valor.replace(".", ",");

    valor = valor.replace(
        /\B(?=(\d{3})+(?!\d))/g,
        "."
    );

    campo.value = "R$ " + valor;
}
// validar estado
function validarEstado(campo) {

    const estados = [
        "AC","AL","AP","AM","BA","CE","DF","ES",
        "GO","MA","MT","MS","MG","PA","PB","PR",
        "PE","PI","RJ","RN","RS","RO","RR","SC",
        "SP","SE","TO"
    ];

    let valor = campo.value
        .replace(/[^a-zA-Z]/g, "")
        .toUpperCase()
        .substring(0, 2);

    campo.value = valor;

    if (valor.length === 2 && !estados.includes(valor)) {

        campo.classList.add("is-invalid");
         mostrarToast("Sigla de estado inválida!");
        return false;
    }

    campo.classList.remove("is-invalid");

    return true;
}


