$(document).ready(function() {

    $('.filter-el').hide()
    $('.author-filter').show()

    $('#author-filter-button').click(function(){
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

    $('#select-filter').change(function() {
        event.preventDefault()
        var filter = $('#select-filter').val()
        if(filter === 'author'){
            $('.filter-el').hide()
            $('.author-filter').show()
        } else if(filter === 'hall') {
            $('.filter-el').hide()
            $('.hall-filter').show()
        } else if(filter === 'material') {
            $('.filter-el').hide()
            $('.material-filter').show()
        }
    })

    $('#hall-filter-button').click(function(){
        event.preventDefault()

        var hallId = $('#hallId').val()
        $.ajax({
            url:'exhibits/filterByHall',
            type:'GET',
            data:{
                hallId: hallId
            },
            success: function (response) {
                $('#main-div').html(response)
            }
        })
    })

    $('#material-filter-button').click(function(){
        event.preventDefault()

        var material = $('#material').val()
        $.ajax({
            url:'exhibits/filterByMaterial',
            type:'GET',
            data:{
                material: material
            },
            success: function (response) {
                $('#main-div').html(response)
            }
        })
    })
})