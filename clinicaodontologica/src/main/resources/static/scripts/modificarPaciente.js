window.addEventListener('load', function () {
    
    const urlListarPaciente = 'api/v1/paciente';
    const form = document.forms[0];
    const id = document.getElementById('inputId');
    const nombre = document.getElementById('inputNombre');
    const apellido = document.getElementById('inputApellido');
    const dni = document.getElementById('inputDni');
    const calle = document.getElementById('inputCalle');
    const numero = document.getElementById('inputNumero');
    const localidad = document.getElementById('inputLocalidad');
    const provincia = document.getElementById('inputProvincia');
    const mensaje = document.querySelector('div.mensaje');    
    const modificar = document.querySelector("#containerForm")
    const fecha = new Date();

    //const container =  document.querySelector('.containerListado');
    /*****************Obtener listado de Odontologos [GET]***************************/

    function listar(){    
        const settings = {
            method: 'GET'
          }
          fetch(urlListarPaciente, settings)
          .then(response => {
            console.log(response)
            return response.json();
          })
          .then(data => {
            console.log('ok ')
            console.log(data)
            renderizarPaciente(data)
            botonesModificarPaciente();
            botonEliminarPaciente();
            
            })
            .catch(error => {
            console.log('Error:'+error)
            
            })
        
      };

    listar();

    /***************Renderizar Odontologos  en el Index************************/


    function renderizarPaciente(listado) {
        for (element of listado) {
          
          let tabla = document.getElementById("bodyTablaListado");
          let deleteButton = `<button class="eliminar" id="${element.id}">Eliminar</button>`
          let updateButton = `<button class="modificar" id="${element.id}">Modificar</button>`
                  
          tabla.innerHTML+= 
            `<td class="td_id">${element.id}</td>
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
            dni: dni.value,
            fecha_Ingreso: fecha,
            domicilio: {                    
                calle: calle.value,
                numero: numero.value,
                localidad: localidad.value,
                provincia: provincia.value
            },
        }
        let settings = {
            method: 'PUT',
            body: JSON.stringify(body),
            headers: {
                'Content-Type': 'application/json'
            }
        };

       modificarPaciente(settings);

        form.reset();
    });

    function modificarPaciente(settings) {

        fetch(urlListarPaciente, settings)
        .then(response => {
            console.log(response)
             return response;
        })

        .then(data => {
           console.log(data);
            mensaje.innerHTML = "Modificado"
            location.reload()
        })

        .catch(error =>{
            mensaje.innerHTML = "Error al cargar un odontologo.. Intente nuevamente..";
            console.log(`Promesa rechazada:`);
            console.error(error)
        })

    };



     /*********************Modificar **************************/

     function botonesModificarPaciente() {
        const botonesModificar = document.querySelectorAll('.modificar');    
        botonesModificar.forEach(boton=>{
          
          boton.addEventListener('click', (e)=>{         
            let idPaciente = boton.getAttribute("id")
            alert("id:" +idPaciente)           
            id.innerHTML = idPaciente
            modificar.removeAttribute("class")
            
          })     
        })  
      }    
      
      /*********************Eliminar**************************/
      function botonEliminarPaciente() {    
        let btnBorrar = document.querySelectorAll('.eliminar');
    
        btnBorrar.forEach(boton =>{
          boton.addEventListener('click', (e)=>{  
            let id = boton.getAttribute("id");
            
            let urlDelete = `${urlListarPaciente}/${id}`  
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