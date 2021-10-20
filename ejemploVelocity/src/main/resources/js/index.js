var correo;
var id;

var btnEnviar = document.getElementById("btnEnviar");
btnEnviar.addEventListener("click", () => {
    axios.post("http://localhost:4567/enviar", {
        email: document.getElementById("email").value,
        password: document.getElementById("password").value
    })
        .then(function (res) {
            alert("Usuario:" + res.data.status + " id:" + res.data.id);
            correo = document.getElementById("email").value;
            id = res.data.id;
        })
        .catch(function (error) {
            console.log(error)
        })
});

var btnIniciar = document.getElementById("btnIniciar");
btnIniciar.addEventListener("click", () => {
    window.location.replace("templates/hola.vm");
});