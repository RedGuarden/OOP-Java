function refreshTable() {
    $.get('/values', function(data) {
        var attr,
            mainTable = $('#mainTable tbody');
        mainTable.empty();
        for (attr in data) {
            if (data.hasOwnProperty(attr)) {
                mainTable.append(row(attr, data[attr]));
            }
        }
    });
}

function deleteKey(key) {
    $.post('/delete', {key: key}, function() {
        refreshTable();
        $('#keyInput').focus();
    });
}


$(document).ready(function() {
    var keyInput = $('#keyInput'),
        valueInput = $('#valueInput');

    refreshTable();
    $('#addForm').on('submit', function(event) {
        var data = {
            key: keyInput.val(),
            value: valueInput.val()
        };
        $.post('/add', data, function() {
            refreshTable();
            keyInput.val('');
            valueInput.val('');
            keyInput.focus();
        });
        event.preventDefault();
    });
    keyInput.focus();
});