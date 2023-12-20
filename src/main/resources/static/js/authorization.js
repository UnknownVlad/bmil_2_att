const usernameAuth = document.querySelector('#user_auth');
const passwordAuth = document.querySelector('#password_auth');
const timeAuth = document.querySelector('#timeValue_auth');


const formAuth = document.querySelector('#authorization');
const button = document.querySelector("#enter");



const checkLogin = () => {

    let valid = false;

    const username = usernameAuth.value.trim();

    if (!isRequired(username)) {
        showError(usernameAuth, 'Поле не может быть пустым.');
    } else {
        showSuccess(usernameAuth);
        valid = true;
    }
    return valid;
};


const checkPasswordAuth = () => {
    let valid = false;

    const password = passwordAuth.value.trim();

    if (!isRequired(password)) {
        showError(passwordAuth, 'Поле не может быть пустым.');
    } else {
        showSuccess(passwordAuth);
        valid = true;
    }

    return valid;
};

const checkTimeAuth = () => {

    let valid = false;

    const time = timeAuth.value.trim();

    if (!isRequired(time)) {
        showError(timeAuth, 'Проблема со временем');
    } else {
        showSuccess(timeAuth);
        valid = true;
    }
    return valid;
};


const ajaxSendAuth = async (formData) => {
    const response = await fetch('/auth', {
                           method: 'POST',
                           body: formData
                       });
                       if (!response.ok) {
                            button.classList.remove("button--loading");
                            let result = await response.json();
//                            alert(result.message);
                            showError(usernameAuth, result.message);
                            throw new Error('Ошибка');
                       }
    return await response.text();
};

formAuth.addEventListener('submit', async function (e) {
    e.preventDefault();

    let isUsernameValid = checkLogin(),
        isPasswordValid = checkPasswordAuth(),
        isTimeValue = checkTimeAuth();

    let isFormValid = isUsernameValid &&
        isPasswordValid &&
        isTimeValue;

    let formData = new FormData(formAuth);

    if (isFormValid) {
        button.classList.add("button--loading");
        ajaxSendAuth(formData).then((response) => {
            console.log(response);
            formAuth.reset();
            button.classList.remove("button--loading");
            alert("Вы успешно авторизовались!");
        })
        .catch((err) => console.error(err))
    }
});

const debounce_2 = (fn, delay = 500) => {
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

formAuth.addEventListener('input', debounce_2(function (e) {
    switch (e.target.id) {
        case 'user_auth':
            checkLogin();
            break;
        case 'password_auth':
            checkPasswordAuth();
            break;
        case 'timeValue_auth':
            checkTimeAuth();
            break;
    }
}));
