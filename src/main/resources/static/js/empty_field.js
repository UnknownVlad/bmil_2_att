$('document').ready(function() {
    $('#reg').on('click', function() {
      $('.modal__container .modal__content .form-element .rfield').each(function() {
        if ($(this).val() != '') {
          console.log(32);
          // Если поле не пустое удаляем класс-указание
          $(this).removeClass('empty_field');
        } else {
          console.log(33);
          // Если поле пустое добавляем класс-указание
          $(this).addClass('empty_field');
        }
      });
    });
  });

$(document).ready(function() {
  $("#form_user").submit(function() {
    name = $("input[name='username']").val();
    password = $("input[name='password']").val();

    console.log("Name " + name);
    console.log("Password" + password);

    return false;
  })
});