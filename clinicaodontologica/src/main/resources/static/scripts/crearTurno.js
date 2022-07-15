window.addEventListener('load', function () {
    const urlListarOdonto = 'api/v1/odontologo';
    const urlListarPaciente = 'api/v1/paciente';
    const urlListarTurno = '/api/v1/turno';
    const selectPaciente = document.querySelector('#paciente');
    const selectOdontologo = document.querySelector('#odontologos');
    const selectFecha = document.querySelector('#fechaTurno')
    const selectHora = document.querySelector('#horaTurno')
    const form = document.forms[0];
    const mensaje = document.querySelector('div.mensaje');


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
        console.log('Promesa rechazada:'+error)

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
            console.log('Promesa rechazada:'+error)

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


cargarPacientes();
cargarOdontologos();

/*********************POST  turnos **************************/

form.addEventListener('submit', function (event) {
  event.preventDefault();
  let opcionOdontologo = selectOdontologo.value
  idOdontologo= opcionOdontologo.split('-')[0];
  let opcionPaciente = selectPaciente.value
  idPaciente= opcionPaciente.split('-')[0];
  let fecha = selectFecha.value;
  let hora = selectHora.value;

  let body= {
            paciente: {
                        id: Number(idPaciente)},
            odontologo:{
                        id: Number(idOdontologo)  },
            fecha: fecha,
            hora: hora.concat(":00")
            
            }

  let settings = {
      method: 'POST',
      body: JSON.stringify(body),
      headers: {
          'Content-Type': 'application/json'
      }
  };
      crearTurno(settings);
      form.reset();

  }); 
           
  function crearTurno(settings) {
        console.log(settings.body)

        fetch(urlListarTurno, settings)

        .then(response => {
            console.log(response)
            if(!response.ok){
                mensaje.innerHTML = "Error al cargar Turno"
            }
            return response.json();
        })

        .then(data => {
           console.log(data);
            if(data){
                mensaje.innerHTML = `Se creo con exito el turno id: ${data.id}`
               
            }
        })

        .catch(error =>{
            console.log("Error: "+ error);
        })
        window.location.replace("index.html");
    };
});




