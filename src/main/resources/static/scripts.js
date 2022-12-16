function cargar2() {
    var Cliente = new XMLHttpRequest();
    Cliente.open("get","http://localhost:8080/pers",true);
    Cliente.responseType = 'json';
    Cliente.onload = function () { 
        if(Cliente.status==200) {
            list_data = Cliente.response._embedded;
            data = document.getElementById("datos");data.innerHTML="";
            for(i=0;i<list_data.Personas.length;i++) {
                nom = document.createElement("p");nom.innerText=list_data.Personas[i].nombres;
                ape = document.createElement("address");ape.innerText=list_data.Personas[i].apellidos;
                carnet = document.createElement("p");carnet.innerText=list_data.Personas[i].cedula;
                btn_del = document.createElement("p");btn_del.innerHTML="X";
                
                btn_del.name=list_data.Personas[i]._links.self; //guardamos el dato
                btn_del.onclick=borrar; // asociamos evento
                btn_edit=document.createElement("address");btn_edit.innerHTML="E";
                btn_edit.param=list_data.Personas[i];
                btn_edit.onclick=editar;
                btn_usuario=document.createElement("p");btn_usuario.innerHTML="USR";
                btn_usuario.param=list_data.Personas[i];
                btn_usuario.onclick=asociar_usuario;

                data.appendChild(carnet);data.appendChild(nom);
                data.appendChild(ape);data.appendChild(btn_del);
                data.appendChild(btn_edit);data.appendChild(btn_usuario);
            }

         }
    };
    Cliente.send();
}

function asociar_usuario(event) {
    var temp = event.target.param._links.self.href;
    var id_per = document.getElementsByName("id_per")[0];
    id_per.value=temp;

}

function editar(event) {
    console.log(event.target.param);
    nombres=document.getElementById("nom");
    nombres.value=event.target.param.nombres;
    apellidos=document.getElementById("apellidos");
    apellidos.value=event.target.param.apellidos;
    cedula=document.getElementById("carnet");
    cedula.value=event.target.param.cedula;
    boton = document.getElementById("grabar");boton.innerHTML="Guardar";
    identificador = document.getElementsByName("id")[0];
    var temp = event.target.param._links.self.href;
    temp = temp.substring(temp.lastIndexOf("/")+1);
    identificador.value= temp;
}
function borrar(event) { 
    var solicitud = new XMLHttpRequest();
    solicitud.open("delete",event.target.name.href,true);
    solicitud.onload=function () {
        if(solicitud.status==204) console.log("Socio Eliminado");
        cargar2();
    }
    solicitud.send();
}

function postear() {
    var postObj=new Object;elem=document.getElementById("grabar");
    postObj.nombres=document.getElementsByName("nom")[0].value;
    postObj.apellidos=document.getElementById("apellidos").value;
    postObj.cedula=document.getElementById("carnet").value;
    if(elem.innerText=="Guardar") 
            postObj.id=document.getElementsByName("id")[0].value;
    let data_post = JSON.stringify(postObj);
    console.log(data_post);
    
    let xhr = new XMLHttpRequest();
    if(elem.innerText=="Guardar") 
        xhr.open("PUT","http://localhost:8080/pers/"+postObj.id,true)
    else xhr.open('POST', "http://localhost:8080/pers", true)
    xhr.setRequestHeader('Content-type', 'application/json; charset=UTF-8')
    xhr.send(data_post);  
    xhr.onload = function () {
        if(xhr.status == 201) {
            console.log("Socio Añadido exitosamente!");
            cargar2();
        }
        if(xhr.status==200) { 
            console.log("Socio Editado exitosamente!");
            cargar2();
            elem.innerText="Añadir"; }
    }
}