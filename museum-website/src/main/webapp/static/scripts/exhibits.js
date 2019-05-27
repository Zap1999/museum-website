$(document).ready(function() {

    $('.filter-el').hide()
    $('.author-filter').show()

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
        } else if(filter === 'technique') {
            $('.filter-el').hide()
            $('.technique-filter').show()
        } else if(filter === 'employee') {
            $('.filter-el').hide()
            $('.employee-filter').show()
        }

    })

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

    $('#technique-filter-button').click(function(){
        event.preventDefault()

        var technique = $('#technique').val()
        $.ajax({
            url:'exhibits/filterByTechnique',
            type:'GET',
            data:{
                technique: technique
            },
            success: function (response) {
                $('#main-div').html(response)
            }
        })
    })

    $('#employee-filter-button').click(function(){
        event.preventDefault()

        var employeeId= $('#employeeId').val()
        $.ajax({
            url:'exhibits/filterByEmployee',
            type:'GET',
            data:{
                employeeId: employeeId
            },
            success: function (response) {
                $('#main-div').html(response)
            }
        })
    })
})