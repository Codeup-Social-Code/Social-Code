//
// function addOnClick() {
//     clicks += 1;
//     document.getElementById("clicks").innerHTML = clicks;
// }

let clicks = 150;
$(".follow").click(function (num) {
    $("#clicks").innerText(clicks + 1);

})

