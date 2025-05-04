$(document).ready(function () {});

async function registrarUsuario() {
  let body = {};

  body.nombre = document.getElementById("regNombre").value;
  body.apellidos = document.getElementById("regApellidos").value;
  body.email = document.getElementById("regEmail").value;
  body.telefono = document.getElementById("regTelefono").value;
  body.password = document.getElementById("regPassword").value;

  repetirContrasena = document.getElementById("regRepetirPassword").value;

  if (body.password !== repetirContrasena) {
    alert("Las contraseñas no coinciden");
    return;
  }

  const response = await fetch("usuario", {
    method: "POST",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    body: JSON.stringify(body),
  });

  window.location.href = "login.html";
}
