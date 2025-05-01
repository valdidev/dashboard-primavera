$(document).ready(function () {});

async function iniciarSesion() {
  let body = {};

  body.email = document.getElementById("loginEmail").value;
  body.password = document.getElementById("loginPassword").value;

  const response = await fetch("login", {
    method: "POST",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    body: JSON.stringify(body),
  });

  const respuesta = await response.text();
  if (respuesta === "OK") {
    window.location.href = "index.html";
  } else {
    alert("Usuario o contraseña incorrectos");
    location.reload();
  }
}
