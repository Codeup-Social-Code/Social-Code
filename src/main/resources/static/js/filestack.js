// "use strict";
// th:inline="javascript";
//
// var apiKey = [[${apiKey}]];
// //testing it gets passed through
// // alert("Your api key is: " + apiKey);
// const client = filestack.init(apiKey);
// $("#upload").click(function () {
//     client.picker(options).open()
// });
//
// const options = {
//     fromSources: ["local_file_system","instagram","facebook"],
//     onUploadDone:
//         function (res){
//             $("#picture").val(res.filesUploaded[0].url);
//             // console.log("url + " + res.filesUploaded[0].url);
//         }
// }