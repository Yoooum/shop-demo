import api from '../request.js';

export const productGetAll = () => {
    return api({
        url: '/api/product/all',
        method: 'GET',
        data: {}
    })
}

export const productGetById = (params) => {
    return api({
        url: '/api/product/id',
        method: 'GET',
        data: params
    })
}

export const productGetByCategory = (params) => {
    return api({
        url: '/api/product/category',
        method: 'GET',
        data: params
    })
}

export const productGetBySearch = (params) => {
    return api({
        url: '/api/product/search',
        method: 'GET',
        data: params
    })
}
