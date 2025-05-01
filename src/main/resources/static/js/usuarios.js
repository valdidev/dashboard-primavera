// Call the dataTables jQuery plugin
$(document).ready(function () {
  cargarUsuarios();
  $("#usuarios").DataTable();
});

async function cargarUsuarios() {
  const response = await fetch("usuarios", {
    method: "GET",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  });

  const usuarios = await response.json();

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

async function eliminarUsuario(id) {
  if (!confirm("¿Eliminar definitivamente al usuario?")) {
    return;
  }

  await fetch("usuario/" + id, {
    method: "DELETE",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  });

  location.reload();
}
