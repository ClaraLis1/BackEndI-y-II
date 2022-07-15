window.addEventListener('load', function () {   
   
    const cerrarSesion = document.querySelector('#closeApp');

    cerrarSesion.addEventListener('click', (e)=>{         
     
      window.location.replace("/login?logout")
      
    })    
   
  
  });