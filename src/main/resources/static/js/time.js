// document.getElementById("myForm").addEventListener("submit", function(event){
//     event.preventDefault();
//     var password = document.getElementById("password").value;
//     var time = calculateKeyPressTime(password);
//     document.getElementById("timeValue").innerHTML = "time";
    
// });


// function calculateKeyPressTime(password){

//     // Создаем пустой массив для хранения времени нажатий на клавиши
//     var keyPressTimes = [];

//     // Получаем поле для ввода пароля

//     // При нажатии на клавишу в поле пароля
//     password.addEventListener('keydown', function(event) {
//       // Получаем текущее время
//       var currentTime = new Date().getTime();

//       // Добавляем время нажатия на клавишу в массив
//       keyPressTimes.push(currentTime);
//     });


//     // var startTime = new Date().getTime();
//     // var endTime = new Date().getTime();
//     // var time = endTime - startTime;
//     return keyPressTimes;
// }

var keyPressTimes = [];
$(document).ready(function() {
    var lastKeypressTime;
    
    $("#password").keypress(function() {
      if (lastKeypressTime === undefined) {
        lastKeypressTime = new Date();
      } else {
        var currentTime = new Date();
        var timeDifference = currentTime - lastKeypressTime;
        keyPressTimes.push(timeDifference);
        lastKeypressTime = currentTime;
      }
    });
  });



  document.getElementById("timeForm").addEventListener("submit", function(event){
    event.preventDefault();
    document.getElementById("timeValue").value = keyPressTimes;
  });