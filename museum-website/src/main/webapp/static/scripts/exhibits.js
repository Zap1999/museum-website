$(document).ready(function() {

    $('#filter-button').click(function(){
        event.preventDefault()

        var authorId = $('#authorId').val()
        $.ajax({
            url:'exhibits/filterByAuthor',
            type:'GET',
            data:{
                authorId:authorId
            },
            success: function (response) {
                $('#main-div').html(response)
            }
        })
    })
})