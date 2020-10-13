
$(document).ready(() => {
    $("#addr").keydown(validateAddr);
    $("#addr").keyup(validateAddr);
    $("#phone").keydown(validatePhone);
    $("#phone").keyup(validatePhone);
    $("#subDistrict").change(validateSubDistrict)
});
function validateSubDistrict() {
    let  val = $("#subDistrict").val();
    console.log(val);
    if (val == null) {
        $("#error-ward").html("<small class=\"d-block text-danger\">Trường bắt buộc</small>");
    }
}

function validatePhone() {
    let val = String($("#phone").val());
    console.log(val);
    val = val.trim();
    if (val === "") {
        $("#error-phone").html("<small class=\"d-block text-danger\">Trường bắt buộc</small>");
    } else {
        $("#error-phone").empty();
    }
};

function validateAddr() {
    let val = String($("#addr").val());
    console.log(val);
    val = val.trim();
    if(val == "") {
        $("#error-addr").html("<small class=\"d-block text-danger\">Trường bắt buộc</small>");
    } else {
        $("#error-addr").empty();
    }
}