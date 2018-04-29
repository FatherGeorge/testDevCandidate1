function displayParts(filtered, sorted, sortField) {

    var dto = new Object();
    dto.partNumber = $('#partNumber').val();
    dto.partName = $('#partName').val();
    dto.vendor = $('#vendor').val();
    dto.qty = $('#qty').val();
    dto.shippedAfter = $('#shippedAfter').val();
    dto.shippedBefore = $('#shippedBefore').val();
    dto.receivedAfter = $('#receivedAfter').val();
    dto.receivedBefore = $('#receivedBefore').val();
    dto.sorted = sorted;
    dto.sortField = sortField;
    dto.filtered = filtered;

    $.ajax({
        url: "/homeServlet",
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify(dto),
        contentType: 'application/json',
        mimeType: 'application/json',

        success: function (data) {

            $('#partsList tbody').remove();

            var options = {
                year: 'numeric',
                month: 'short',
                day: 'numeric'
            }

            $.each(data, function (index, part) {
                $("#partsList").append($('<tr/>')
                    .append($('<td/>').html(part.partNumber))
                    .append($('<td/>').html(part.partName))
                    .append($('<td/>').html(part.vendor))
                    .append($('<td/>').html(part.quantity))
                    .append($('<td/>').html(new Date(part.shipped).toLocaleDateString("en-US", options)))
                    .append($('<td/>').html(new Date(part.received).toLocaleDateString("en-US", options)))
                );
            });
        },

        error: function (data, status, er) {
            alert("error: " + data + " status: " + status + " er:" + er);
        }
    })
}


