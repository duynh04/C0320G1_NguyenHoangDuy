

$( window ).on( "load", () => {
    getListName("db/city.json", "#city");
    getListName("db/district.json", "#district", "tinh_id", 1);
    getListName("db/ward.json", "#subDistrict", "huyen_id", 1);
});

$(document).ready(() => {
    $("#city").change(() => {
        getListName("db/district.json", "#district", "tinh_id", $("#city").val());
        // $("#subDistrict").empty();
        $("#district").trigger('change');
        // getListName("db/ward.json", "#subDistrict", "huyen_id", 1)
    });

    $("#district").change(() => {
        // console.log($("#district").val());
        getListName("db/ward.json", "#subDistrict", "huyen_id", $("#district").val())
    })
});

function getListName(url, selector, filterName = '', filterId = undefined) {
    $.getJSON(url, (data) => {
        $(selector).empty();
        data.filter(val => val[filterName] == filterId)
            .forEach(val => $(selector).append(new Option(val.name, val.id)))
    })
}