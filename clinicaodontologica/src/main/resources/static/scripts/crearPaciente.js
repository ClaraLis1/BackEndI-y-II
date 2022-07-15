window.addEventListener('load', function () {
    const url = '/api/v1/paciente'
    const form = document.forms[0];
    const nombre = document.getElementById('inputNombre');
    const apellido = document.getElementById('inputApellido');
    const dni = document.getElementById('inputDni');
    const calle = document.getElementById('inputCalle');
    const numero = document.getElementById('inputNumero');
    const localidad = document.getElementById('inputLocalidad');
    const provincia = document.getElementById('inputProvincia');
    const mensaje = document.querySelector('div.mensaje');
    const fecha = new Date();
    
    
    form.addEventListener('submit', function (event) {

        event.preventDefault();
       

        let body= {
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
            method: 'POST',
            body: JSON.stringify(body),
            headers: {
                'Content-Type': 'application/json'
            }
        };

        crearPaciente(settings);

        form.reset();

    });

   
    function crearPaciente(settings) {
        console.log(settings.body)

        fetch(url, settings)

        .then(response => {
            console.log(response)
            if(!response.ok){
                mensaje.innerHTML = "Error al cargar Paciente"
            }
            return response.json();
        })

        .then(data => {
           console.log(data);

            if(data){
                mensaje.innerHTML = "Se creo con exito el paciente id:"+ data.id;
            }
        })

        .catch(error =>{           
            console.log("Error: "+ error);
        })
        
        window.location.replace("index.html");
                
    };
});


