const usernameEl = document.querySelector('#username');
const passwordEl = document.querySelector('#password');
const timeEl = document.querySelector('#timeValue');


const form = document.querySelector('#registration');
const btn = document.querySelector("#button");



const checkUsername = () => {

    let valid = false;

    const min = 2,
        max = 25;

    const username = usernameEl.value.trim();

    if (!isRequired(username)) {
        showError(usernameEl, 'Поле не может быть пустым.');
    } else if (!isBetween(username.length, min, max)) {
        showError(usernameEl, `Длина имени должна быть не меньше ${min} символов и не больше ${max} символов.`)
    } else {
        showSuccess(usernameEl);
        valid = true;
    }
    return valid;
};


const checkPassword = () => {
    let valid = false;


    const password = passwordEl.value.trim();

    if (!isRequired(password)) {
        showError(passwordEl, 'Поле не может быть пустым.');
    } else if (!isPasswordSecure(password)) {
        showError(passwordEl, 'Минимум 6 символов: буквы верхнего и нижнего регистра, цифры');
    } else {
        showSuccess(passwordEl);
        valid = true;
    }

    return valid;
};

const checkTimeValue = () => {

    let valid = false;

    const time = timeEl.value.trim();

    if (!isRequired(time)) {
        showError(timeEl, 'Проблема со временем');
    } else {
        showSuccess(timeEl);
        valid = true;
    }
    return valid;
};

const isPasswordSecure = (password) => {
    const re = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{6,})");
    return re.test(password);
};

const isRequired = value => value === '' ? false : true;
const isBetween = (length, min, max) => length < min || length > max ? false : true;


const showError = (input, message) => {
    const formField = input.parentElement;
    formField.classList.remove('success');
    formField.classList.add('error');

    const error = formField.querySelector('small');
    error.textContent = message;
};

const showSuccess = (input) => {
    const formField = input.parentElement;

    formField.classList.remove('error');
    formField.classList.add('success');

    const error = formField.querySelector('small');
    error.textContent = '';
}

const ajaxSend = async (formData) => {
    const response = await fetch('/registration', {
                           method: 'POST',
                           body: formData
                       });
                       if (!response.ok) {
                            btn.classList.remove("button--loading");
                            let result = await response.json();
//                            alert(result.message);
                            showError(usernameEl, result.message);
                            throw new Error('Ошибка');
                       }
    return await response.text();
};

form.addEventListener('submit', async function (e) {
    e.preventDefault();

    let isUsernameValid = checkUsername(),
        isPasswordValid = checkPassword(),
        isTimeValue = checkTimeValue();

    let isFormValid = isUsernameValid &&
        isPasswordValid &&
        isTimeValue;

    let formData = new FormData(form);

    if (isFormValid) {
        btn.classList.add("button--loading");
        ajaxSend(formData).then((response) => {
            console.log(response);
            form.reset();
            btn.classList.remove("button--loading");
//            alert(response);
        })
        .catch((err) => console.error(err))
    }
});


const debounce = (fn, delay = 500) => {
    let timeoutId;
    return (...args) => {
        if (timeoutId) {
            clearTimeout(timeoutId);
        }
        timeoutId = setTimeout(() => {
            fn.apply(null, args)
        }, delay);
    };
};

form.addEventListener('input', debounce(function (e) {
    switch (e.target.id) {
        case 'username':
            checkUsername();
            break;
        case 'password':
            checkPassword();
            break;
        case 'timeValue':
            checkTimeValue();
            break;
    }
}));

