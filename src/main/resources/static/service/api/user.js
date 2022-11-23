import api from '../request.js';

export const userLogin =(params) => {
    return api({
        url: '/api/user/login',
        method: 'POST',
        data: params
    })
}

export const userRegister =(params) => {
    return api({
        url: '/api/user/register',
        method: 'POST',
        data: params
    })
}