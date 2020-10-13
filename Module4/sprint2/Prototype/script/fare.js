

const DAY_OF_WEEK = ['CN', 'T2', 'T3', 'T4', 'T5', 'T6', 'T7'];

$(window).on('load', function () {
    $('#dep-detail-0').hide();
    $('#dep-detail-1').hide();
    $('#dep-detail-2').hide();
});

$(document).ready(function () {
    // set date for searching
    setDate('2020-08-27', '#departure-date');
    setDate('2020-09-07', '#return-date');
    $('#btn-dep-detail-0').on('click', function () {
        $('#dep-detail-0').toggle();
    })
    $('#btn-dep-detail-1').on('click', function () {
        $('#dep-detail-1').toggle();
    })
    $('#btn-dep-detail-2').on('click', function () {
        $('#dep-detail-2').toggle();
    })
    //hide show selection
    $('button').on('click', function () {
        //change text
        let textBtn = $(this).text();
        if (textBtn == 'Chọn') {
            $(this).text('Thay đổi');
            $(this).css({'background-color': '#00aeef', 'border-color': '#00aeef'});

        } else if (textBtn == 'Thay đổi') {
            $(this).text('Chọn');
            $(this).css({"background-color": "#ffa801", 'border-color': '#ffa801'});
        } else {
            return;
        }
        let sel = $(this).attr('id').split('-');
        toggleSelection(parseInt(sel[2]), sel[0]);
    })
});


function setDate(_date, dateType) {
    $(dateType).find('a').each(function (index) {
        let dateValue = addDate(_date, index);
        let result = `${DAY_OF_WEEK[dateValue.getDay()]}(${dateValue.getDate()}/${dateValue.getMonth() + 1})`;
        $(this).text(result);
    });
}

function addDate(someDate, days) {
    let _temp = new Date(someDate);
    _temp.setDate(_temp.getDate() + days);
    return _temp;
}

function toggleSelection(selId, selType) {
    //departure
    for (let i = 0; i < 5; i++) {
        if (i !== selId) {
            $(`#${selType}-row-${i}`).toggle();
        }
    }
}
