console.log("Entro a GetRequest");
document.addEventListener("DOMContentLoaded", function() {

  const camionSection = document.getElementById("camion");
  const camiones = [];

  function loadCamionList() {
    console.log("Entro a loadCamionList");
    fetch("/aduana24115?action=getAll")
      .then(response => response.json())
      .then(data => {
        console.log("data : "+ data);
        data.forEach(camion =>{
          camiones.push(camion);
          camionSection.innerHTML += `
            <tr>
              <td>${camion.id}</td>
              <td>${camion.empresa}</td>
              <td>${camion.tipoCarga}</td>
              <td>${camion.paisOrigen}</td>
              <td>${camion.paisDestino}</td>
         
            </tr>
          `
        });
      });
  }
  loadCamionList();
});
