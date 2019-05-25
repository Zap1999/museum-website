function posChanged() {

        console.log("lol");

        var pos = $("#posSelect option:selected").val();

    $.ajax({
        url:'employees/filterByPosition',
        type:'GET',
        data:{
            position:pos
        },
        success: function (response) {
            $('#main-div').html(response)
        },
        complete: function (data) {
            $("#posSelect").val(pos);
        }
    })
}