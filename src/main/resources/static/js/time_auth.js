 var keyPressTimes_auth = [];
  $(document).ready(function() {
      var lastKeypressTime_auth;

      $("#password_auth").keypress(function() {
        if (lastKeypressTime_auth === undefined) {
          lastKeypressTime_auth = new Date();
        } else {
          var currentTime = new Date();
          var timeDifference = currentTime - lastKeypressTime_auth;
          keyPressTimes_auth.push(timeDifference);
          lastKeypressTime_auth = currentTime;
        }
      });
    });

    var input = document.querySelector('#password_auth')
    input.addEventListener('keyup', function(e) {
      const inputElement = document.querySelector('#timeValue_auth');
      inputElement.value = keyPressTimes_auth;
    })