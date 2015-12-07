$(document).ready(function() {
    /** Shows joke when "Tell Joke" button clicked.*/
    $('#tell_joke').on('click', function() {
        $.get('/_ah/api/jokesApi/v1/joke', function(data) {
            $('#joke').html(data.joke);
        })
    });
});