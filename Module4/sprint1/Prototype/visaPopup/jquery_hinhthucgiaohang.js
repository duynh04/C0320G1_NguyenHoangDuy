$(document).ready(function ($) {
    $('#selectBank').click(function () {
        $('#visa').css("display", "none");
        $('#bank').css( "display", "block");
    });
    $('#selectVisa').click(function () {
        $('#visa').css( "display", "block");
        $('#bank').css("display", "none")
    });
    $('#select').click(function () {
        $('#bank').css("display", "none");
        $('#visa').css("display", "none");
    });

    $("input[name='bank']").click(() => {
        $("#bankModal").modal();
    });
    $("#sel-visa").click(() => {
        $("#visaModal").modal();
    });

});