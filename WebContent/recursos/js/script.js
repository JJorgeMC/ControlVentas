//15:32
    $(function(){
        inicio();
        navViewDefaul();
        llenarTablas();
        llenarSelects();
    });

    function llenarTablas(){
        listarCategorias();    
        listarProductos();
    }

    function llenarSelects(){
        llenarSelectRol();
        llenarSelectPro();
        llenarSelectCat();                
    }


//SESIÓN///////////////////SESIÓN///////////////////////SESIÓN////////////////////SESIÓN//////////////////////SESIÓN///////////////////////////////
//SESIÓN///////////////////SESIÓN///////////////////////SESIÓN////////////////////SESIÓN//////////////////////SESIÓN///////////////////////////////


    var sesion_init;

    var sesion_usuario_id;
    var sesion_usuario_nombre;
    var sesion_usuario_rol;

    var sesion_cliente_id;
    var sesion_cliente_nombre;
    var sesion_cliente_dni;
    
    var venta_state;
    var venta_num_doc;

    var listaProductos_venta;

    var listaVenta = [];

//OBJETOS//////////////////OBJETOS///////////////////OBJETOS///////////////////OBJETOS/////////////////OBJETOS//////////    
//OBJETOS//////////////////OBJETOS///////////////////OBJETOS///////////////////OBJETOS/////////////////OBJETOS//////////    

    function Venta(){
        this.tipo_doc = tipo_doc;
        this.num_doc = num_doc;
        this.fecha_venta = null;
        this.id_usuario = id_usuario;
        this.id_venta = id_venta;
    }
    //constructor
    function DetalleVenta(nombre, cantidad, precio, id_producto){
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.id_producto = id_producto;        
    }


//NAVEGACIÓN///////////////////NAVEGACIÓN///////////////////////NAVEGACIÓN////////////////////////NAVEGACIÓN////////////////////NAVEGACIÓN///////////////////////
//NAVEGACIÓN///////////////////NAVEGACIÓN///////////////////////NAVEGACIÓN////////////////////////NAVEGACIÓN////////////////////NAVEGACIÓN///////////////////////


    function inicio(){
        $("#aInicio").show();
        $("#aCategorias").hide();
        $("#aProductos").hide();
        $('#aUsuarios').hide();
        $('#aRoles').hide();
        $('#aClientes').hide();
        $('#aVentas').hide();        
    }
    function categorias(){
        $("#aInicio").hide();
        $("#aCategorias").show();
        $("#aProductos").hide();
        $('#aUsuarios').hide();
        $('#aRoles').hide();
        $('#aClientes').hide();
        $('#aVentas').hide(); 
    }
    function productos(){
        $("#aInicio").hide();
        $("#aCategorias").hide();
        $("#aProductos").show();
        $('#aUsuarios').hide();
        $('#aRoles').hide();
        $('#aClientes').hide();
        $('#aVentas').hide(); 
    }
    function showUsuarios(){
        $("#aInicio").hide();
        $("#aCategorias").hide();
        $("#aProductos").hide();
        $('#aUsuarios').show();
        $('#aRoles').hide();
        $('#aClientes').hide();
        $('#aVentas').hide(); 
    }
    function showRoles(){
        $("#aInicio").hide();
        $("#aCategorias").hide();
        $("#aProductos").hide();
        $('#aUsuarios').hide();
        $('#aRoles').show();
        $('#aClientes').hide();
        $('#aVentas').hide(); 
    }
    function showClientes(){
        $("#aInicio").hide();
        $("#aCategorias").hide();
        $("#aProductos").hide();
        $('#aUsuarios').hide();
        $('#aRoles').hide();
        $('#aClientes').show();
        $('#aVentas').hide(); 
    }
    function showVentas(){
        $("#aInicio").hide();
        $("#aCategorias").hide();
        $("#aProductos").hide();
        $('#aUsuarios').hide();
        $('#aRoles').hide();
        $('#aClientes').hide();
        $('#aVentas').show(); 
        resetVenta();
        // $('#ventaCliente').hide();
    }
    function showLogin(){
        $("#dBlur").fadeIn("fast",function(){
            $("#first").fadeIn("fast");    
        });    
    }    
    function hideLogin(){
        cleanLog();
        cleanReg();    
        $("#second").fadeOut("fast", function(){
            $('#dBlur').fadeOut();
        });
        $("#first").fadeOut("fast",function(){
            $("#dBlur").fadeOut();
        });
    }
    function hideSignCliente(){
        cleanRegCliente();
        $("#sign-cliente").fadeOut("fast", function(){
            $('#dBlur').fadeOut();
        });

    }
    
    //NAV VIEW//////////////////NAV VIEW////////////////////NAV VIEW///////////////////NAV VIEW/////////////////////////NAV VIEW//////////
    function navViewVendedor(){
        $('#liCat').hide();
        $('#liPro').hide();
        $('#liUsu').hide();
        $('#liRol').hide();
        $('#liCli').hide();
        $('#liVen').show();
        $('#liLog').hide();
        $('#liLogout').show();
    }
    function navViewAdmin(){
        $('#liCat').show();
        $('#liPro').show();
        $('#liUsu').show();
        $('#liRol').show();
        $('#liCli').show();
        $('#liVen').hide();
        $('#liLog').hide();
        $('#liLogout').show();
    }
    function navViewDefaul(){
        $('#liCat').hide();
        $('#liPro').hide();
        $('#liUsu').hide();
        $('#liRol').hide();
        $('#liCli').hide();
        $('#liVen').hide();
        $('#liLog').show();
        $('#liLogout').hide();
    }
    function setNavView(){
        switch(sesion_usuario_rol){
            case 1:
                navViewAdmin();
                break;
            case 2:
                navViewVendedor();
                break;
            default:
                console.log("Error rol fuera de rango: "+sesion_usuario_rol);
        }
    }



//LISTAR//////////////////////LISTAR/////////////////////LISTAR//////////////////////LISTAR//////////////////////////LISTAR//////////////////
//LISTAR//////////////////////LISTAR/////////////////////LISTAR//////////////////////LISTAR//////////////////////////LISTAR//////////////////


    function listarCategorias(){
        var i, c = 1;
        $.get("cc",{opc:2},function(data){
            var d = JSON.parse(data);
            $("#tCategorias tbody").empty();
            for(i = 0;i<d.length;i++){
                $("#tCategorias tbody").append(
                    "<tr><td>"+c+"</td><td>"+d[i].nombre_cat+"</td><td><a href='#' style='color: green;' onclick='updateCat("+d[i].id_categoria+")'><i class='far fa-edit'></i></a><a style='color: red;'onclick='deleteCat("+d[i].id_categoria+")'><i class='far fa-trash-alt'></i></a></td></tr>"
                );
                c++;
            }
        });
    }
    function listarProductos(){
        var i , c = 1;
        $.get("pc", {opc:2}, function(data){
            var p = JSON.parse(data);
            $("#tProductos tbody").empty();
            for(i = 0;i < p.length; i++){
                $("#tProductos tbody").append("<tr><td>"+c+"</td><td>"+p[i].nombre_pro+"</td><td>"+p[i].nombre_cat+"</td><td>"+p[i].precio+"</td><td>"+p[i].cantidad+"</td><td><a href='#' style='color: green;' onclick='updatePro("+p[i].id_producto+")'><i class='far fa-edit'></i></a><a href='#' style='color: red;'onclick='deletePro("+p[i].id_producto+")'><i class='far fa-trash-alt'></i></a></td></tr>");
                c++;
            }
        });
    }
    //RETORNA LISTA///////////////////////////////////////////
    



    //SELECT////////////////////SELECT/////////////////////SELECTED/////////////////////////SELECTED////////////////
    function llenarSelectCat(){
        var i;
        $.get("cc",{opc:2}, function(data){
            var p = JSON.parse(data);
            $("#sCategoria").empty();
            $("#sCategoria").append("<option value='0'>---</option>");
            for( i =  0; i< p.length; i++){
                $("#sCategoria").append("<option value="+p[i].id_categoria+">"+p[i].nombre_cat+"</option> ");
            }
            console.log("se lleno");
        }
        );
    }
    function llenarSelectRol(){
        var i;
        $.get("rc", {opc:2}, function(data){
            var r = JSON.parse(data);
            $("#sRol").empty();
            $("#sRol").append("<option value='0'>---</option>");
            for(i=0; i < r.length; i++){
                $('#sRol').append("<option value="+r[i].id_rol+">"+r[i].nombre_rol+"</option>");
            }
        });
    }
    function llenarSelectPro(){
        var i;
        $.get("pc", {opc: 2},function(data){
            var p = JSON.parse(data);
            listaProductos_venta = p.slice();
            $("#sProductos").empty();
            $('#sProductos').append("<option value='-1'>---</option>");
            for(i = 0; i < p.length; i++){
                $('#sProductos').append("<option value="+i+">"+p[i].nombre_pro+"</option>");
            }

        });
    }

//UPDATE///////////////////UPDATE///////////////////////////UPDATE////////////////////////UPDATE//////////////////////////////UPDATE/////////
//UPDATE///////////////////UPDATE///////////////////////////UPDATE////////////////////////UPDATE//////////////////////////////UPDATE/////////


    function updateCat(id){
        $.post("cc",{id:id, opc:4},function(data){
            var x = JSON.parse(data);
            var id = $("#id_categoria").val(x.id_categoria);
            var name = $("#tNombre").val(x.nombre_cat);
            console.log("updateCat perfformed!!!")
        })
    }
    function updatePro(id){
        $.post("pc",{id:id, opc:4},function(data){
            var x = JSON.parse(data);
            var id = $("#id_producto").val(x.id_producto);
            var name = $("#tNombrePro").val(x.nombre_pro);
            var cat = $("#sCategoria").val(x.id_categoria);
            var precio = $("#tPrecio").val(x.precio);
            var cant  = $("#tCantidad").val(x.cantidad);
    
            console.log("updateCat perfformed!!!")
        })
    }
    function updateListaVentas(td){
        var row = td.parentElement.parentElement;
        var pos = row.rowIndex-1;
        $('#hiddenProducto').val(pos);
        var pos_pro;
        for(let i = 0; i < listaProductos_venta.length; i++){
            if(listaVenta[pos].id_producto == listaProductos_venta[i].id_producto){
                pos_pro = i;
            }
        }
        $('#sProductos').val(pos_pro);
        $('#tCanPro').val(listaVenta[pos].cantidad);        
        
    }


//DELETE///////////////////////DELETE/////////////////////////DELETE/////////////////////////DELETE////////////////////////////DELETE////////
//DELETE///////////////////////DELETE/////////////////////////DELETE/////////////////////////DELETE////////////////////////////DELETE////////


    function deleteCat(id){
        bootbox.confirm("Desea eliminar?", function(result){
            if(result){
                bootbox.alert("Registro eliminado satisfactoriamente...",function(){
                    $.post("cc", {id:id, opc:3}, function(data){
                        listarCategorias();                    
                    });
                });
            }else{
                bootbox.alert("El registro no se elimino...");
            }
        });
    }
    function deletePro(id){    
        bootbox.confirm("Desea eliminar esta producto?", function(result){
            if(result){
                bootbox.alert("El producto se elimino satisfactoriamente...", function(){
                    $.post("pc", {id:id, opc:3}, function(data){
                        listarProductos();
                        llenarSelectPro();
                    });
                })
            }else{
                bootbox.alert("El registro no se elimino...");
            }
        });
    }
    function deleteListaVentas(td){
        var row = td.parentElement.parentElement;
        var pos = row.rowIndex-1;
        listaVenta.splice(pos, 1);
        listarProductosVenta();
    }


//EVENTS//////////////////EVENTS///////////////////EVENTS////////////////////////EVENTS///////////////////////EVENTS////////////////////////////
//EVENTS//////////////////EVENTS///////////////////EVENTS////////////////////////EVENTS///////////////////////EVENTS////////////////////////////


    //BOTONES////////////////BOTONES//////////////////////BOTONES///////////////////////BOTONES//////////////////////BOTONES////////////
    $("#bEnviarCat").click(function(){
        var name = $("#tNombre").val();
        var id = $("#id_categoria").val();
        $.post("cc", {name:name, id:id, opc:1}).done(function(data){
            $("#id_categoria").val(0);
            bootbox.alert(data);
            cleanCat();
            listarCategorias();
            llenarSelectCat();
            
        });
    });
    $("#bEnviarPro").click(function(){
        var id = $("#id_producto").val();
        var id_cat = $("#sCategoria").val()
        var name = $("#tNombrePro").val();
        var precio = $("#tPrecio").val();
        var cant = $("#tCantidad").val();
        $.post("pc", {id:id,id_cat:id_cat,name:name, precio:precio, cant:cant, opc: 1},function(data){
            $("#id_producto").val(0);
            bootbox.alert(data);        
        });
        llenarSelectCat();
        cleanPro();        
        listarProductos();
        llenarSelectPro();
    });
    //Inicio de sesión
    $('#bLog').click(function(){
        var name = $('#logName').val();
        var pass = $('#logPass').val();
        $.post("uc", {name:name, pass:pass, opc:1}, function(data){
            sesion_init = JSON.parse(data);
            if(sesion_init){
                hideLogin();
                $.post("uc", {name:name, pass:pass, opc:2}, function(data){
                    console.log(data);
                    var g = JSON.parse(data);
                    sesion_usuario_id = g.id_usuario;
                    sesion_usuario_nombre = g.nombre_usu;
                    sesion_usuario_rol = g.id_rol;
                    setNavView();
                });
            }else{
                cleanLog();
                bootbox.alert('El usuario o contraseña no es valido!!!');
            }
        });                
    });
    //Registrar usuario
    $('#bSign').click(function(){
        var name = $('#regName').val();
        var rol = $('#sRol').val();
        var clave = $('#regPass').val();
        $.post("uc", {name:name, rol:rol, clave:clave, opc: 3}, function(data){
            bootbox.alert(data);            
        });
        $("#second").fadeOut("fast", function(){
            $("#first").fadeIn();
        });
    });
    //Cerrar sesión
    $('#aLogout').click(function(){
        if(!venta_state){
            sesion_init = false;
            sesion_usuario_id = null;
            sesion_usuario_nombre = null;
            sesion_usuario_rol = null;        
            inicio();
            navViewDefaul();
        }else{
            bootbox.alert('No se puede cerrar sesión cuando una venta esta activa')
        }
    });

    ///CLIENTE//////////CLIENTE//////////////////CLIENTE////////////////////CLIENTE///////////////////CLIENTE

    //Acción de Registrar cliente
    $('#bRegCli').click(function(){
        $("#dBlur").fadeIn("fast",function(){
            $("#sign-cliente").fadeIn("fast");    
        }); 
    });

    $('#bSignCli').click(function(){
        var name = $('#tNameCli').val();
        var dni = $('#tDniCli').val();
        //post
        $.post('clc', {name: name, dni: dni, opc: 1}).done(function(data){
            bootbox.alert(data);
            $('#tDni').val(dni);
        });

        hideSignCliente();
    });

    //VENTA////////////VENTA////////////VENTA//////////VENTA
    $('#bInitVenta').click(function(){
        $('#bInitVenta').fadeOut('fast', function(){
            $('#ventaCliente').fadeIn('fast');
            venta_state = true;  
            $.get("vc", {opc: 6}, function(data){
                sesion_num_doc = JSON.parse(data);
                $('#tNumDoc').val(sesion_num_doc);
            });          
        });
        
    });
    $('#bConfVent').click(function(){
        var dni = $('#tDni').val();
        var i;
        if(true){
            let id_usuario = sesion_usuario_id;
            console.log("1. "+id_usuario);
            let id_cliente = sesion_cliente_id;
            console.log("2. "+id_cliente);
            let tipo_doc = $('#sTipoDoc').val();
            console.log("3. "+tipo_doc);
            let num_doc = sesion_num_doc;
            console.log("4. "+num_doc);
            
            $.post("vc", {id_usuario: id_usuario, id_cliente: id_cliente, tipo_doc: tipo_doc, num_doc: num_doc, opc: 1}).done(function(){
                console.log('Entro a post')
                console.log('length: ' + listaVenta.length);
                for(i = 0; i < listaVenta.length; i++){
                    console.log('Entro a for')
                    console.log('val1:'+sesion_num_doc +', val2: '+listaVenta[i].id_producto +', val3: '+listaVenta[i].precio+ ',val4: '+ listaVenta[i].cantidad);
                    $.post('pc', {opc: 5, cant: listaVenta[i].cantidad, id: listaVenta[i].id_producto});
                    $.post("dvc",{val1:sesion_num_doc, val2: listaVenta[i].id_producto, val3: listaVenta[i].precio,val4: listaVenta[i].cantidad, opc: 1}).done(function(){
                        console.log('Detalle '+i+' creado');
                    });
                }
                //AL FINAL                
                resetVenta();
            });
        }        
    });
    $('#bAgrePro').click(function(){
        //Crear el Objeto detalleVenta
        var num_pro = $('#sProductos').val();
        var nombre = listaProductos_venta[num_pro].nombre_pro;
        var cant = $('#tCanPro').val();
        var precio = listaProductos_venta[num_pro].precio * cant;
        var id_pro = listaProductos_venta[num_pro].id_producto;
        var det_pro = new DetalleVenta(nombre, cant, precio, id_pro);
        var hidden = $('#hiddenProducto').val()
        if(hidden == ""){
            listaVenta[listaVenta.length] = det_pro;
        }else{
            listaVenta[hidden] = det_pro;
            $('#hiddenProducto').val("");
        }
                
        //limpiar
        cleanAgrePro();
        //listar detalle Productos
        listarProductosVenta();
    });
    function listarProductosVenta(){
        var precio_total = 0;
        $('#tableVentas tbody').empty();
        for(var i = 0; i < listaVenta.length; i++){
            precio_total+= parseInt(listaVenta[i].precio);
            $('#tableVentas tbody').append(
                "<tr><td>"+(i+1)+"</td><td>"+listaVenta[i].nombre+"</td><td>"+listaVenta[i].cantidad+"</td><td>"+listaVenta[i].precio+"</td><td><a href='#' style='color: green;' onclick='updateListaVentas(this)'><i class='far fa-edit'></i></a><a href='#' style='color: red;'onclick='deleteListaVentas(this)'><i class='far fa-trash-alt'></i></a></td></tr>"
            );
        }
        $('#spanPrecio').text(precio_total);
    }    
    function resetVenta(){
        cleanVenta();
        listaVenta = [];
        listarProductosVenta();
        sesion_cliente_id = null;
        sesion_cliente_nombre = null;
        sesion_cliente_dni = null;    
        venta_state = false;
        llenarSelectPro();    
        $('#ventaCliente').fadeOut('fast',function(){
            $('#bInitVenta').fadeIn('fast');
        });        
    }
    

//AUXILIARES///////////////////AUXILIARES///////////////////AUXILIARES//////////////////AUXILIARES///////////////////////AUXILIERES///////////
    //CLEAN/////////////////////CLEAN////////////////////////CLEAN////////////////////////CLEAN///////////////////////CLEAN///////////////////////
    function cleanCat(){
        $("#tNombre").val("");
        $("#tNombre").focus();
    }
    
    function cleanPro(){
        $("#sCategoria").val("0")
        $("#tNombrePro").val("");
        $("#tPrecio").val("");
        $("#tCantidad").val("");
        $("#tNombrePro").focus();
    }
    function cleanLog(){
        $("#logName").val("");
        $("#logPass").val("");
    }
    function cleanReg(){
        $("#regName").val("");
        $("#regPass").val("");
        $("#sRol").val("");
    }
    function cleanRegCliente(){
        $('#tNameCli').val("");
        $('#tDniCli').val("");
    }
    function cleanVenta(){
        $('#tDni').val('');
        $('#sTipoDoc').val(0);
        cleanAgrePro();
    }
    function cleanAgrePro(){
        $('#sProductos').val(-1);
        $('#tCanPro').val("");
        $('#sProductos').trigger('change');
    }
//LOGIN////////////////////LOGIN//////////////////////LOGIN///////////////////////LOGIN///////////////////////////LOGIN///////////////////////
//LOGIN////////////////////LOGIN//////////////////////LOGIN///////////////////////LOGIN///////////////////////////LOGIN///////////////////////


    $("#signup").click(function() {
        cleanLog();
        $("#first").fadeOut("fast", function() {
            $("#second").fadeIn("fast");
        });
    });
        
    $("#signin").click(function() {
        cleanReg();
        $("#second").fadeOut("fast", function() {
            $("#first").fadeIn("fast");
        });
    });    
    //fin del login
    $(".backInicio").click(function(){
        hideLogin();
    });
    $('.backVenta').click(function(){
        hideSignCliente();
    });
    

//VALIDAR/////////////////VALIDAR/////////////////////VALIDAR////////////////////////VALIDAR/////////////////////VALIDAR///////////////VALIDAR//
//VALIDAR/////////////////VALIDAR/////////////////////VALIDAR////////////////////////VALIDAR/////////////////////VALIDAR///////////////VALIDAR//

    function validarDNI(){
        let dni = $('#tDni').val();
        $.get('clc', {dni:dni,opc:6}, function(state){
            let s = JSON.parse(state);
            if(s){
                $.get('clc', {dni:dni, opc:2}, function(data){
                    var d = JSON.parse(data);
                    sesion_cliente_nombre = d.nombre_cli
                    sesion_cliente_dni = d.dni;
                    sesion_cliente_id = d.id_cliente;
                    bootbox.alert('El cliente esta registrado');
                });
            }else{
                bootbox.alert('El cliente no esta registrado');
            }
        })
    }
//VALIDAR//////////////VALIDAR////////////////VALIDAR//////////VALIDAR///////////VALIDAR///
//VALIDAR//////////////VALIDAR////////////////VALIDAR//////////VALIDAR///////////VALIDAR///

    // Validar stock
    $('#sProductos').change(function(){
        $('#tCanPro').trigger('change');
    });
    $('#tCanPro').change(function(e){
        let cant = $(e.target).val();
        $(e.target).removeClass('border border-success border-danger');
        if($('#sProductos').val() == -1 || $(e.target).val() == ""){

        }else{
            var stock = listaProductos_venta[$('#sProductos').val()].cantidad;
            if(stock>= cant){
                $(e.target).addClass('border border-success');
            }else{
                $(e.target).addClass('border border-danger');
            }            
        }
    }); 