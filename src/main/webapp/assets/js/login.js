$(document).ready(function () {

    $("#LoginForm").on('submit', function (event) {
        event.preventDefault();
        event.stopPropagation();

        let form = $('#LoginForm');

        let formData = new FormData(form[0]);

        $.ajax({
            url: 'login',
            type: 'POST',
            data: formData,
            cache: false,
            contentType: false,
            processData: false,
            success: function (response) {
                console.log(response)
                if (response.status === "success") {
                    window.location.href = 'home';
                } else if (response.status === "error") {
                    swal('Error', response.message, 'error');
                }
            },
            error: function (response) {
                console.log(response)
                swal('Error', 'Error', 'error');
            }
        });

    });
});
