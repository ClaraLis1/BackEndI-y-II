window.addEventListener('load', function () {
    const url = '/api/v1/odontologo'
    const form = document.forms[0];
    const nombre = document.getElementById('inputNombre');
    const apellido = document.getElementById('inputApellido');
    const matricula = document.getElementById('inputMatricula');
    const mensaje = document.querySelector('div.mensaje');
    
    
    
    form.addEventListener('submit', function (event) {

        event.preventDefault();
        
        let body= {
            nombre: nombre.value,
            apellido: apellido.value,
            matricula: matricula.value
        }

        let settings = {
            method: 'POST',
            body: JSON.stringify(body),
            headers: {
                'Content-Type': 'application/json'
            }
        };

        crearOdontologo(settings);

        form.reset();

    });

   
    function crearOdontologo(settings) {

        fetch(url, settings)
        .then(response => {
            console.log(response)
            if(!response.ok){
                mensaje.innerHTML = "Error al cargar Odontologo"
            }
            return response.json();
        })

        .then(data => {
            console.log(data);

            if(data){
                mensaje.innerHTML = "Se creó un Odontologo con éxito!";
               //location.replace('/index.html');
            }
        })

        .catch(error =>{
            mensaje.innerHTML = "Error al cargar un odontologo.. Intente nuevamente..";
            console.error(error)
        })
        window.location.replace("index.html");
    };
});