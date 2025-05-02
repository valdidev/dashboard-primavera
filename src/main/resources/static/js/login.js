$(document).ready(function () {});

async function iniciarSesion() {
  const email = document.getElementById("loginEmail").value;
  const password = document.getElementById("loginPassword").value;

  try {
      const response = await fetch("login", {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify({ email, password }),
      });

      if (!response.ok) {
          const error = await response.text();
          throw new Error(error || "Error en credenciales");
      }

      const token = await response.text();
      
      if (token === "KO") {
          alert("Credenciales incorrectas");
          return;
      }

      // Guardar token en localStorage y redirigir
      localStorage.setItem("token", token);
      localStorage.setItem("email", email);
      window.location.href = "usuarios.html";

  } catch (error) {
      console.error("Error en login:", error);
      alert(error.message || "Error al iniciar sesión");
  }
}
