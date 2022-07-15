window.addEventListener('load', function () {
    
    const url = '/api/v1/odontologo';
    const form = document.forms[0];
    const id = document.getElementById('inputId');
    const nombre = document.getElementById('inputNombre');
    const apellido = document.getElementById('inputApellido');
    const matricula = document.getElementById('inputMatricula');
    const mensaje = document.querySelector('div.mensaje');
    const modificar = document.querySelector("#containerForm")

    //const container =  document.querySelector('.containerListado');
    /*****************Obtener listado de Odontologos [GET]***************************/

    function listar(){    
        const settings = {
            method: 'GET'
           }    
 
        fetch(url, settings)
            .then(response => {
            console.log(response)
            return response.json();
            })
              .then(data => {
              console.log('ok ')
              console.log(data)
              renderizarOdonto(data)
              botonesModificarOdonto();
              botonEliminarOdonto();
            
            })
            .catch(error => {
            console.log('Error:'+error)
            
            })
        
      };

    listar();

    /***************Renderizar Odontologos  en el Index************************/


    function renderizarOdonto(listado) {
        for (element of listado) {
          let tabla = document.getElementById("bodyTablaListado");
          let deleteButton = `<button class="eliminar" id="${element.id}">Eliminar</button>`
          let updateButton = `<button class="modificar" id="${element.id}">Modificar</button>`
                  
          tabla.innerHTML+= `<td class="td_id">${element.id}</td> 
          <td class="td_nombre"> ${element.nombre.toUpperCase()}</td>
          <td class="td_apellido"> ${element.apellido.toUpperCase()} </td>
          <td> ${updateButton}</td>
          <td> ${deleteButton}</td>`
        }      
      };
    
    
    
  /*********************Modificar PUT **************************/ 
    
   form.addEventListener('submit', function (event) {
  
        event.preventDefault();        
        let body= {            
            id:Number(id.value),
            nombre: nombre.value,
            apellido: apellido.value,
            matricula: Number(matricula.value)
        }
        let settings = {
            method: 'PUT',
            body: JSON.stringify(body),
            headers: {
                'Content-Type': 'application/json'
            }
        };

       modificarOdontologo(settings);

        form.reset();
    });

    function modificarOdontologo(settings) {

        fetch(url, settings)
        .then(response => {
            console.log(response)
             return response;
        })

        .then(data => {
            console.log(`Promesa cumplida:`);
            console.log(data);
            mensaje.innerHTML = "Modificado"
            location.reload()
        })

        .catch(error =>{
            mensaje.innerHTML = "Error al cargar un odontologo.. Intente nuevamente..";
            console.error(error)
        })

    };



     /*********************Modificar **************************/

     function botonesModificarOdonto() {
        const botonesModificar = document.querySelectorAll('.modificar');    
        botonesModificar.forEach(boton=>{
          
          boton.addEventListener('click', (e)=>{ 
            let idOdonto = boton.getAttribute("id")
            alert("el id es :"+ idOdonto)
            id.innerHTML = idOdonto
            modificar.removeAttribute("class")
            
          })     
        })  
      }    
      
      /*********************Eliminar**************************/
      function botonEliminarOdonto() {    
        let btnBorrar = document.querySelectorAll('.eliminar');
    
        btnBorrar.forEach(boton =>{
          boton.addEventListener('click', (e)=>{  
            let id = boton.getAttribute("id");
            
            let urlDelete = `${url}/${id}`  
            const settings = {
              method: 'DELETE',
              headers: {
               // 'Content-Type': 'application/javascript'
              //  authorization: token
              }
            }
            fetch(urlDelete, settings)
            .then(response => {
              console.log('Borrado de tarea:')
              console.log(response.status)
              location.reload();
              
            })
            .catch(error => {
              console.log('Error:')
              console.error(error)
            })
          })
        })
    
    
      };

    
});