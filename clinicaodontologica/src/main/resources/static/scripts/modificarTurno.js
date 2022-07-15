window.addEventListener('load', function () { 
   
    const urlListarTurno = 'api/v1/turno';
    const container =  document.querySelector('.containerListado');
    const urlListarOdonto = 'api/v1/odontologo';
    const urlListarPaciente = 'api/v1/paciente';  
    const id = document.getElementById('inputId'); 
    const selectPaciente = document.querySelector('#paciente');
    const selectOdontologo = document.querySelector('#odontologos');
    const selectFecha = document.querySelector('#fechaTurno')
    const selectHora = document.querySelector('#horaTurno')
    const form = document.forms[0];
    const modificar = document.querySelector("#containerForm")
    const mensaje = document.querySelector('div.mensaje');
    
    const buttonturnos = document.querySelector('#listaTurnos')

    
  
    /*********************Obtener listado de Turnos [GET]***************************/         
    function listar(){

        const settings = {
        method: 'GET'
        }

        fetch(urlListarTurno, settings)
            .then(response => {
            console.log(response)
            
        return response.json();
        })
        .then(data => {
            console.log('ok ')
            console.log(data)
            renderizarTurnos(data)
            botonesModificarTurno();
            botonEliminarTurno();

        })
        .catch(error => {
        console.log('Error:'+error)

        })

    };
  
    listar();
  
    /*********************Renderizar Lista de turnos en el Index**************************/

    function renderizarTurnos(listado) {
      for (turno of listado) {

                let tabla = document.getElementById("bodyTablaListado");
                let deleteButton = `<button class="eliminar" id="${turno.id}">Eliminar</button>`
                let updateButton = `<button class="modificar" id="${turno.id}">Modificar</button>`

                tabla.innerHTML+=
                 `<td class="td_id">${turno.id}</td>
                <td class="td_paciente"> ${turno.paciente.nombre.toUpperCase()} ${turno.paciente.apellido.toUpperCase()}</td>
                <td class="td_odontologo"> ${turno.odontologo.nombre.toUpperCase()} ${turno.odontologo.apellido.toUpperCase()}</td>
                <td class="td_fecha"> ${turno.fecha}</td>
                <td class="td_hora"> ${turno.hora}</td>
                <td>${updateButton}</td>
                <td>${deleteButton}</td>`
      }      
    };

    form.addEventListener('submit', function (event) {  
        event.preventDefault();    
            
        let opcionOdontologo = selectOdontologo.value
        idOdontologo= opcionOdontologo.split('-')[0];
        let opcionPaciente = selectPaciente.value
        idPaciente= opcionPaciente.split('-')[0];
        let fecha = selectFecha.value;
        let hora = selectHora.value;

        let body= {  
            id:Number(id.value),          
            paciente: {
                id: Number(idPaciente)
                },
            odontologo:{
                id: Number(idOdontologo)
                },
            fecha: fecha,
            hora: hora.concat(":00")       
        }

        let settings = {
            method: 'PUT',
            body: JSON.stringify(body),
            headers: {
                'Content-Type': 'application/json'
            }
        };

        modificarTurno(settings);
        form.reset();
    });

    function modificarTurno(settings) {

        fetch(urlListarTurno, settings)
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
            console.log(`Error:`);
            console.error(error)
        })

    };

     /*********************Modificar **************************/

    function botonesModificarTurno() {
        const botonesModificar = document.querySelectorAll('.modificar');    
        botonesModificar.forEach(boton=>{
          
          boton.addEventListener('click', (e)=>{         
            let idTurno = boton.getAttribute("id")
            alert("el id es :"+ idTurno)
            modificar.removeAttribute("class")
            cargarPacientes();
            cargarOdontologos();
            
          })     
        })  
      }  

   
      /*********************Obtener los Pacientes **************************/

    function cargarPacientes(){
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
          renderizarListado("paciente", data)
  
        })
        .catch(error => {
          console.log('Error:'+error)
  
        })
  
      };
  
  /*********************Obtener los Odontologos **************************/
  
         function cargarOdontologos(){
            const settings = {
              method: 'GET'
            }
            fetch(urlListarOdonto, settings)
            .then(response => {
              console.log(response)
              
              return response.json();
            })
            .then(data => {
              console.log('ok ')
              console.log(data)
              renderizarListado("odontologos", data)
  
            })
            .catch(error => {
              console.log('Error:'+error)
  
            })
  
          };
  
          function renderizarListado(domElement, listado) {
          let select = document.getElementsByName(domElement)[0];
                for (element of listado) {
                  let option = document.createElement("option");
                    option.text = element.id +"- " + element.nombre +" " + element.apellido;
                    select.add(option);
                }
             }
   
      /*********************Eliminar**************************/
      function botonEliminarTurno() {    
        let btnBorrar = document.querySelectorAll('.eliminar');
    
        btnBorrar.forEach(boton =>{
          boton.addEventListener('click', (e)=>{  
            let id = boton.getAttribute("id");
            
            let urlDelete = `${urlListarTurno}/${id}`  
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