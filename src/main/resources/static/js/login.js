document
.getElementById("formLogin")
.addEventListener("submit", async function(e){

    e.preventDefault();

    const login =
        document.getElementById("login").value;

    const senha =
        document.getElementById("senha").value;

    if(login.trim() === ""){
        alert("Informe o login");
        return;
    }

    if(senha.trim() === ""){
        alert("Informe a senha");
        return;
    }

    console.log(login);
    console.log(senha);

    // Integração Spring Boot
    /*
    const response = await fetch('/login', {
        method:'POST',
        headers:{
            'Content-Type':'application/json'
        },
        body:JSON.stringify({
            login,
            senha
        })
    });

    if(response.ok){
        window.location.href='/menu';
    }
    */
});


