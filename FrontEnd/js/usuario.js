const form = document.getElementById("usuario-form")

form.addEventListener('submit', event => { // ouvir até o submit ser acionado
    event.preventDefault();

    const formData = new FormData(form); // Pega o formulário e java em uma variável 
    const data = Object.fromEntries(formData); // Se torna em objeto 

    fetch("http://localhost:8080/usuarios", {
        method: 'POST',
        headers: {
            'Content-Type':'application/json'
        },
        body: JSON.stringify(data)
    }).then(res => res.json())
        .then(data => console.log(data))
        .catch(error => console.log(error));
});

function msg() {
    alert("Salvo com sucesso!");
    window.location.reload(true);
  }

  //table - trazer usuários cadastrados na tela
fetch("http://localhost:8080/usuarios").then((data)=>{
    return data.json();
  }).then((todosUsuarios) =>{
      let data1 = "";
      todosUsuarios.map((values) =>{
          data1 += `
          <tbody>
              <tr>
                  <th scope="row">${values.id} </td>
                  <td>${values.nomeUsuario}</td> 
                  <td>${values.dataNascimento}</td> 
                  <td>${values.cpf} </td>
                  <td>${values.email}</td> 
              </tr>
          </tbody>
          `
      })
      document.getElementById("usuarioDados").innerHTML = data1;
      console.log(todosUsuarios);
  })
  