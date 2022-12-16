function grabarUSR() {
    var postObj=new Object;
    postObj.usr=document.getElementById("usu").value;
    postObj.clave=document.getElementById("pass").value;
    // Referencia a la Persona/Socio
    var id_persona=document.getElementsByName("id_per")[0].value;
    // Verificamos si el socio tiene Usuario
    var consulta = new XMLHttpRequest();
    consulta.open("get",id_persona+"/usr",true);
    consulta.send();
    consulta.onload = function () {
        ref_usu="";
        if(consulta.status==200) {
            ref_usu = JSON.parse(consulta.response);
            ref_usu = ref_usu._links.self.href;
            console.log(ref_usu);
        }
        let data_post = JSON.stringify(postObj);
        let xhr = new XMLHttpRequest();
        xhr.open('POST', "http://localhost:8080/usuarios", true)
        xhr.setRequestHeader('Content-type', 'application/json; charset=UTF-8')
        xhr.send(data_post);  
        xhr.onload = function () {
        if(xhr.status == 201) {
            let xhr2 = new XMLHttpRequest();
            console.log(id_persona);
            xhr2.open("put",id_persona+"/usr",true);
            xhr2.setRequestHeader('Content-type', 'text/uri-list');
            dato = 'http://localhost:8080/usuarios/'+postObj.usr;
            console.log(dato);
            xhr2.send(dato);
            xhr2.onload =function() {
                if (xhr2.status==204) {
                    let borrar = new XMLHttpRequest();
                    borrar.open("delete",ref_usu,true);
                    borrar.send();
                    borrar.onload = function(){
                    if(borrar.status==204) 
                    console.log("Usuario anterior eliminado");
                    }
                console.log("Usuario Añadido y Asociado exitosamente!"); 
            }
        }
    }
 }
}
}