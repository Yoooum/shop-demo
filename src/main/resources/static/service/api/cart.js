import api from '../request.js';

export const cartInsert = (userId,productId) => {
    return api({
        url: '/api/cart/new/' + userId + '/' + productId,
        method: 'GET',
        data: {}
    })
}

export const cartGetAll = (userId) => {
    return api({
        url: '/api/cart/' + userId,
        method: 'GET',
        data: {}
    })
}

export const cartDelete = (params) => {
    return api({
        url: '/api/cart/delete',
        method: 'POST',
        data: params
    })
}

export const cartUpdate = (params) => {
    return api({
        url: '/api/cart/update',
        method: 'POST',
        data: params
    })
}

export const cartDeleteAll = (params) => {
    return api({
        url: '/api/cart/delete/all',
        method: 'POST',
        data: params
    })
}