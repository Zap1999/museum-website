function posChanged() {

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
};

function dateChanged() {

    var startDateOrigin = $("#dateStartSelect").val();
    var endDateOrigin = $("#dateFinishSelect").val();
    var startDate = startDateOrigin.replace('T', ' ');
    var endDate = endDateOrigin.replace('T', ' ');

    if (startDate && endDate) {
        $.ajax({
            url: 'employees/filterByDate',
            type: 'GET',
            data: {
                startDate: startDate,
                endDate: endDate
            },
            success: function (response) {
                $('#main-div').html(response)
            },
            complete: function (data) {
                $("#dateStartSelect").val(startDateOrigin);
                $("#dateFinishSelect").val(endDateOrigin);
            }
        })
    }

}