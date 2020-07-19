// /$(document).on(
// 'click',
//     '.follow',
//     function(event) {
//         debugger;
//         event.preventDefault();
//         var cur = "#" + this.id;
//         var toFollow = {
//             "followeeID" : this.id
//         };
//
//         $.ajax({
//             url : "../follow/add",
//             data : toFollow,
//             dataType : 'json',
//             type : "POST",
//             success : function(data) {
//                 if (data) {
//                     console.log(data);
//                     console.log(cur);
//                     $(cur).removeClass("btn-default")
//                         .addClass("btn-success");
//                     $(cur).removeClass("follow").addClass(
//                         "follow");
//                     $(cur).html("Following");
//                 } else {
//                     console.log(data);
//                     $(cur).addClass("btn-default")
//                         .removeClass("btn-success");
//                     $(cur).removeClass("follow").addClass(
//                         "follow");
//                     $(cur).html("Follow");
//                 }
//
//             }
//         })
//     });
// });
