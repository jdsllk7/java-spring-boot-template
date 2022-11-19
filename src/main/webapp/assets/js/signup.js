$(document).ready(function () {

    $("#SignupForm").on('submit', function (event) {
        event.preventDefault();
        event.stopPropagation();

        let form = $('#SignupForm');

        let formData = new FormData(form[0]);

        swal({
            title: "Confirm",
            text: "Are you sure you want to signup?",
            type: "warning",
            showCancelButton: true,
            confirmButtonClass: "btn-danger",
            confirmButtonText: "Yes",
            closeOnConfirm: false
        }, function () {
            $.ajax({
                url: 'signup',
                type: 'POST',
                data: formData,
                cache: false,
                contentType: false,
                processData: false,
                success: function (response) {
                    console.log(response)
                    if (response.status === "success") {
                        swal({
                                title: "Success",
                                text: response.message,
                                type: 'success',
                                showCancelButton: false,
                                confirmButtonClass: "btn-primary",
                                confirmButtonText: "Okay",
                                closeOnConfirm: true
                            },
                            function () {
                                window.location.href = 'home';
                            });
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
});
