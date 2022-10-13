    //pegar valor digitado pelo cliente no id
    const idUsuario = document.querySelector("#idUsuario");

    idUsuario.addEventListener('blur', (e) =>{
      const idUser = idUsuario.value;
      console.log(idUser);
  
    //cabeçalho que vai no fecth
     const options = {
      method: 'GET',
      cache: 'default'
     }
  //fetch
  //devemos no ${} usar a crase
  fetch(`http://localhost:8080/usuarios/pesquisaid/${idUser}`, options)
    .then(response => {response.json()
      .then(data => atribuirCampos(data))
    })
    .catch(e => console.log("Deu erro: " + e))
    })
  
  function atribuirCampos(data)
    {
    const nomeUsuario = document.querySelector("#nomeUsuario");
    const dataNascimento = document.querySelector("#dataNascimento");
    const cpf = document.querySelector("#cpf");
    const email = document.querySelector("#email");
      
    nomeUsuario.value = data.nomeUsuario;
    dataNascimento.value = data.dataNascimento;
    cpf.value = data.cpf;
    email.value = data.email;
    console.log(email);
    }
  
