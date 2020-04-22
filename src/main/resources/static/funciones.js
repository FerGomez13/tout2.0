function eliminar(id ) {
    swal({
        title: "Estas seguro que desea eliminar?",
        text: "Once deleted, you will not be able to recover this imaginary file!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((OK) => {
            if (OK) {
                $.ajax({
                    url:/eliminar/+id, success :function (res) {
                        console.log(res);
                    }
                });
                swal("Dato Eliminado", {
                    icon: "success",
                }).then((ok)=>{
                    if (ok){
                        location.href="/Lista";
                    }
                });
            } else {
                swal("Your imaginary file is safe!");
            }
        });
}