
function cargarArchivo(elemento){
    var file = elemento.files[0];
    var objHidden = document.subirArchivo.nombre;
    
    objHidden.value = file.name;
    
    //document.subirArchivo.target = "null";
    document.subirArchivo.action = "ServletDescargaArchivo";
    document.subirArchivo.submit();
    alert("Archivo cargado");
}
