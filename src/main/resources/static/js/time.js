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

  var input = document.querySelector('#password')
  input.addEventListener('keyup', function(e) {
    const inputElement = document.querySelector('#timeValue');
    inputElement.value = keyPressTimes;
  })



  // document.getElementById("timeForm").addEventListener("submit", function(event){
  //   event.preventDefault();
  //   document.getElementById("timeValue").value = keyPressTimes;
  // });