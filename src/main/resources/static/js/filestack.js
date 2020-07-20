"use strict";

var apiKey = [[${apiKey}]];
//testing it gets passed through
// alert("Your api key is: " + apiKey);
const client = filestack.init(apiKey);
// client.picker().open();
// $("#upload").click(function () {
//     client.picker().open()
// });

$("#upload").click(function () {
    client.picker(options).open()
});

const options = {
        fromSources: ["local_file_system","instagram","facebook"],
        onUploadDone:
            function (res){
                console.log(res.filesUploaded[0].url);
                alert("Log fired");
            }
    }


