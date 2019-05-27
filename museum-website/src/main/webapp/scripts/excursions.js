function dateChanged() {

    var startDateOrigin = $("#dateStartSelect").val();
    var endDateOrigin = $("#dateFinishSelect").val();
    var startDate = startDateOrigin.replace('T', ' ');
    var endDate = endDateOrigin.replace('T', ' ');

    if (startDate && endDate) {
        $.ajax({
            url: 'excursions/filterByDate',
            type: 'GET',
            data: {
                startDate: startDate,
                endDate: endDate
            },
            success: function (response) {
                $('#main-div').html(response);
            },
            complete: function (data) {
                $("#dateStartSelect").val(startDateOrigin);
                $("#dateFinishSelect").val(endDateOrigin);
            }
        })
    }

};

function clearDates() {
    $("#dateStartSelect").val('');
    $("#dateFinishSelect").val('');
    $.ajax({
        url: 'excursions/filterByDate',
        type: 'GET',
        data: {
            startDate: "null",
            endDate: "null"
        },
        success: function (data) {
            $('#main-div').html(data);
        }
    })
};