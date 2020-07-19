


//
// $("#follow_me").click(function () {
//     let clicks = {user: 150};
//     $.ajax({
//         type: "POST",
//         data: JSON.stringify(clicks),
//         url: "users/follow-test",
//         contentType: "application/json"
//     }).done(function (res) {
//         $("#clicks").html(res);
//     });
//
// })


let totalFollowers =
    JSON.stringify({
        user: 150
    });

$.ajax({
    URL: 'http://localhost/users/follow-test',
    type: 'POST',
    contentType: 'application/json',
    data: totalFollowers,
    success: function (data, status, xhr) {
        $("#clicks").html(res);
    },
    error: function (xhr, status, error) {
        alert('Update Error occurred - ' + error);
    }
});















// $(function() {
//     $(".followUser").click(function()
//     {
//         let userid = $(this).attr("id");
//         let dataString = 'userid='+ userid ;
//         let parent = $(this);
//
//         $("#followButton").fadeOut(300);
//         $.ajax({
//             type: "POST",
//             url: "follow.php",
//             data: dataString,
//             cache: false,
//
//             success: function(html)
// {
//     $("#followButton").html('<button id="' +userid+ '" name="unfollow" class="btn btn-danger unfollowUser">Unfollow</button>');
//     $("#followButton").fadeIn(300);
//
// }
// });
// return false;
// });
// });
//
// $(function() {
//     $(".unfollowUser").click(function()
//     {
//         let userid = $(this).attr("id");
//         let dataString = 'userid='+ userid ;
//         let parent = $(this);
//
//         $("#followButton").fadeOut(300);
//         $.ajax({
//             type: "POST",
//             url: "unfollow.php",
//             data: dataString,
//             cache: false,
//
//             success: function(html)
//             {
//                 $("#followButton").html('<button id="' +userid '" name="follow" class="btn btn-info followUser">Follow</button>');
//                 $("#followButton").fadeIn(300);
//
//             }
//         });
//         return false;
//     });
// });
