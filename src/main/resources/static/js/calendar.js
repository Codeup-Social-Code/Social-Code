"use strict";
$(function() {

    $(document).ready(function() {
        // Fetch our events
        $.ajax({
            url: "/posts.json",
            method: "GET",
            datatype: "json",
            data: {
                "$where" : "start_date_time > '" + moment().subtract(31, 'days').format("YYYY-MM-DDT00:00:00") + "'",
                "city" : "Portland",
                "$order" : "start_date_time DESC"
            }
        }).done(function(response) {
            // Parse our events into an event object for FullCalendar
            var events = [];
            $.each(response, function(idx, e) {
                events.push({
                    start: e.start_date_time,
                    end: e.end_date_time,
                    title: e.title
                });
            });
            console.log(events)
            $('#calendar').fullCalendar({
                // eventClick: function(info) {
                //     alert('Event: ' + info.e.title);
                //     alert('Coordinates: ' + info.jsEvent.pageX + ',' + info.jsEvent.pageY);
                //     alert('View: ' + info.view.type);
                //
                //     // change the border color just for fun
                //     info.el.style.borderColor = 'red';
                //     info.jsEvent.preventDefault(); // don't let the browser navigate
                //
                //     if (info.event.url) {
                //         window.open(info.event.url);
                //     }
                // },
                events: events,
            });
            // $('.fc-title').click(function () {
            //     let title = $(this).text();
            //     let link = `
            //                 <a href="http://localhost:8080/search?term=${title}">
            //                 `;
            //     // $(".fc-title").append(link);
            //     ($(".fc-title").append(link));
            //     alert($(".fc-title").append(link));
            //     console.log($(".fc-title").append(link));
            //     // $("#dialog").dialog();
            //     $( "#dialog" ).dialog( "open" );
            // })
        });
    });
});