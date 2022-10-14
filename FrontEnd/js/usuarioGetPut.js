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
  
    //Método para atualizar cadastro de clientes 

    const btnUpdate = document.querySelector("#btnUpdate");

    btnUpdate.addEventListener('click', (e) =>{
      //Pega o valor digitado pelo cliente no id
      const idUsuario2 = document.querySelector("#idUsuario");
      const idUser2 = idUsuario2.value;
      console.log(idUser2)

      const form = document.getElementById("pesquisaUsuario");
      const formData = new FormData (form);
      const data = Object.fromEntries(formData);


      //Enviado ao backend
      fetch(`http://localhost:8080/usuarios/put/${idUser2}`,{
        method: 'PATCH',
        cache: 'default',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
      }).then(res => res.json())
          .then(data => console.log(data))
          .catch(error => console.log(error));

    });

    function msg() {
      alert("Atualizado com sucesso");
      window.location.reload(true);
    }