$(document).ready(function () {
  $("#usuarios").DataTable();
  cargarUsuarios();
  rellenarDatosUsuario();
});

async function cargarUsuarios() {
  const response = await fetch("api/usuarios", crearRequestInfo("GET"));
  const usuarios = await response.json();
  rellenarTabla(usuarios);
}

async function eliminarUsuario(id) {
  if (!confirm("¿Eliminar definitivamente al usuario?")) {
    return;
  }

  await fetch("api/usuario/" + id, crearRequestInfo("DELETE"));
  location.reload();
}

function crearRequestInfo(metodo) {
  return {
    method: metodo,
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
      Authorization: "Bearer " + localStorage.getItem("token"),
    },
  };
}

function rellenarTabla(usuarios) {
  let listaUsuariosHtml = "";

  for (let usuario of usuarios) {
    let usuarioHtml = `
        <tr>
            <td>${usuario.id}</td>
            <td>${usuario.nombre}</td>
            <td>${usuario.email}</td>
            <td>${usuario.telefono}</td>
            <td>
                <a href="#" onclick="eliminarUsuario(${usuario.id})" class="btn btn-danger btn-circle">
                    <i class="fas fa-trash"></i>
                </a>
            </td>
        </tr>
        `;
    listaUsuariosHtml += usuarioHtml;
  }

  document.querySelector(
    "#usuarios tbody"
  ).outerHTML = `<tbody>${listaUsuariosHtml}</tbody>`;
}

function rellenarDatosUsuario() {
  document.getElementById("txtUsuarioEmail").outerHTML =
    localStorage.getItem("email") ?? "Invitado";
}
